package net.scott.minecraftvillagerdimensionmod.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.mob.SpellcastingIllagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

public class PillagerWizardBossEntity extends SpellcastingIllagerEntity implements GeoEntity {

    // This is for animation
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    // This is for the boss bar
    private ServerBossBar bossBar = null;

    // This data member is for loot tables
    public static final RegistryKey<LootTable> LOOT_TABLE_KEY = RegistryKey.of(
            RegistryKeys.LOOT_TABLE,
            Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "entities/wizardpillager")
    );

    // This function is for creating the entity
    public PillagerWizardBossEntity(EntityType<? extends SpellcastingIllagerEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = new ServerBossBar(
                Text.literal("Mortvax The Chaotic"), // Boss bar title
                ServerBossBar.Color.BLUE,           // Boss bar color
                ServerBossBar.Style.PROGRESS       // Boss bar style
        );
    }

    // This function is also for creating the entity, but this sets his stats
    public static DefaultAttributeContainer.Builder createPillagerWizardBossAttributes() {
        return PillagerEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 250)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f)
                .add(EntityAttributes.GENERIC_ARMOR, 3.0f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15);
    }

    // This function is for setting goal priorities and handles how the entity ai behaves
    @Override
    protected void initGoals() {
        // **Target Selection**
        this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, VillagerEntity.class, true));

        // **Combat and Spellcasting Priorities**
        this.goalSelector.add(2, new ThrowSnowballSpellGoal()); // Prioritize spellcasting
        this.goalSelector.add(3, new SummonFangsGoal()); // Special attack when possible
        this.goalSelector.add(4, new MeleeAttackGoal(this, 0.6F, true));  // Melee attack if spell is unavailable

        // **Basic Movement and Awareness**
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 12.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));

        // **Tactical Movement (Optional)**
        this.goalSelector.add(7, new FleeEntityGoal<>(this, PlayerEntity.class, 10.0F, 0.5F, 0.8F)); // Runs if low health
        this.goalSelector.add(8, new WanderAroundGoal(this, 0.3F, 20)); // Only wander when idle
    }

    // This is a useless function for this entity. But you have to override from the parent class.
    @Override
    public void addBonusForWave(ServerWorld world, int wave, boolean unused) {
        // Do nothing
    }

    // This function is for registering animation controllers, and it dictates what predicate to send an animation instance to.
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<GeoAnimatable>(this, "controller", 0, this::predicate));
        controllers.add(new AnimationController<GeoAnimatable>(this, "attackcontroller", 0, this::attackpredicate));
    }

    // This function is for handling attack animations
    private PlayState attackpredicate(AnimationState<GeoAnimatable> tAnimationState) {
        SpellcastingIllagerEntity.Spell currentSpell = this.getSpell();
        if (this.handSwinging) {
            // If target is close enough, use melee attack animation.  -- && currentSpell == SpellcastingIllagerEntity.Spell.NONE
            if (this.getTarget() != null && this.getTarget().squaredDistanceTo(this) <= 9.0 ) {
                tAnimationState.getController().forceAnimationReset();
                tAnimationState.getController().setAnimationSpeed(2.0F);
                tAnimationState.getController().setAnimation(
                        RawAnimation.begin().then("animation.model.swing", Animation.LoopType.PLAY_ONCE)
                );
            }
            // Otherwise, if a spell is being cast, play its animation.
            if(currentSpell != SpellcastingIllagerEntity.Spell.NONE) {
                String animation;
                switch (currentSpell) {
                    case FANGS:
                        animation = "animation.model.chant";
                        break;
                    case SUMMON_VEX:
                        animation = "animation.model.launch_projectile";
                        break;
                    default:
                        animation = "";
                }
                if (!animation.isEmpty()) {
                    tAnimationState.getController().forceAnimationReset();
                    tAnimationState.getController().setAnimationSpeed(2.0F);
                    tAnimationState.getController().setAnimation(
                            RawAnimation.begin().then(animation, Animation.LoopType.PLAY_ONCE)
                    );
                }
            }
            this.handSwinging = false;
        }
        return PlayState.CONTINUE;
    }

    // Function for basic walk/idle animations
    private PlayState predicate(AnimationState<GeoAnimatable> tAnimationState) {
        if(tAnimationState.isMoving()){
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.walk", Animation.LoopType.LOOP));
        }
        else {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    // This function makes the boss never despawn from the world.
    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false; // Prevents natural despawning
    }

    // Another useless function that I have to override from parent class.
    @Override
    public SoundEvent getCelebratingSound() {
        return null;
    }

    // This function is a helper for animations
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    // The tick function is mostly for the boss bar, but can be useful for other events.
    @Override
    public void tick() {
        super.tick();

        // Update boss bar percentage
        if (!this.getWorld().isClient && this.isAlive()) {
            this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
        }
    }

    // This function is for the spell sounds - I use MC's Default
    @Override
    protected SoundEvent getCastSpellSound() {
        return SoundEvents.ENTITY_EVOKER_CAST_SPELL;
    }

    // This is for the boss bar
    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player); // Add player to boss bar
    }
    // This is for the boss bar
    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player); // Remove player from boss bar
    }

    // This is for the loot table
    @Override
    protected RegistryKey<LootTable> getLootTableId() {
        return LOOT_TABLE_KEY;
    }

    //******************************************************************************************************************//
    //                                      Spell Class Definitions
    //******************************************************************************************************************//
    // Cast Fangs
    class SummonFangsGoal extends CastSpellGoal {
        @Override
        protected int getSpellTicks() {
            return 100;
        }

        @Override
        protected int startTimeDelay() {
            return 340;
        }

        @Override
        protected void castSpell() {
            // Set the animation for summoning fangs.
            PillagerWizardBossEntity.this.setSpell(SpellcastingIllagerEntity.Spell.FANGS);
            LivingEntity target = PillagerWizardBossEntity.this.getTarget();
            double d = Math.min(target.getY(), PillagerWizardBossEntity.this.getY());
            double e = Math.max(target.getY(), PillagerWizardBossEntity.this.getY()) + 1.0;
            float f = (float) MathHelper.atan2(target.getZ() - PillagerWizardBossEntity.this.getZ(), target.getX() - PillagerWizardBossEntity.this.getX());
            if (PillagerWizardBossEntity.this.squaredDistanceTo(target) < 9.0) {
                for (int i = 0; i < 5; i++) {
                    float g = f + (float) i * (float) Math.PI * 0.4F;
                    this.conjureFangs(PillagerWizardBossEntity.this.getX() + MathHelper.cos(g) * 1.5,
                            PillagerWizardBossEntity.this.getZ() + MathHelper.sin(g) * 1.5, d, e, g, 0);
                }
                for (int i = 0; i < 8; i++) {
                    float g = f + (float) i * (float) Math.PI * 2.0F / 8.0F + (float) (Math.PI * 2.0 / 5.0);
                    this.conjureFangs(PillagerWizardBossEntity.this.getX() + MathHelper.cos(g) * 2.5,
                            PillagerWizardBossEntity.this.getZ() + MathHelper.sin(g) * 2.5, d, e, g, 3);
                }
            } else {
                for (int i = 0; i < 16; i++) {
                    double h = 1.25 * (i + 1);
                    int j = i;
                    this.conjureFangs(PillagerWizardBossEntity.this.getX() + MathHelper.cos(f) * h,
                            PillagerWizardBossEntity.this.getZ() + MathHelper.sin(f) * h, d, e, f, j);
                }
            }
        }

        private void conjureFangs(double x, double z, double maxY, double y, float yaw, int warmup) {
            BlockPos blockPos = BlockPos.ofFloored(x, y, z);
            boolean foundSolid = false;
            double offset = 0.0;

            do {
                BlockPos belowPos = blockPos.down();
                BlockState blockState = PillagerWizardBossEntity.this.getWorld().getBlockState(belowPos);
                if (blockState.isSideSolidFullSquare(PillagerWizardBossEntity.this.getWorld(), belowPos, Direction.UP)) {
                    if (!PillagerWizardBossEntity.this.getWorld().isAir(blockPos)) {
                        BlockState blockState2 = PillagerWizardBossEntity.this.getWorld().getBlockState(blockPos);
                        VoxelShape voxelShape = blockState2.getCollisionShape(PillagerWizardBossEntity.this.getWorld(), blockPos);
                        if (!voxelShape.isEmpty()) {
                            offset = voxelShape.getMax(Direction.Axis.Y);
                        }
                    }
                    foundSolid = true;
                    break;
                }
                blockPos = blockPos.down();
            } while (blockPos.getY() >= MathHelper.floor(maxY) - 1);

            if (foundSolid) {
                PillagerWizardBossEntity.this.getWorld().spawnEntity(
                        new EvokerFangsEntity(PillagerWizardBossEntity.this.getWorld(), x, blockPos.getY() + offset, z, yaw, warmup, PillagerWizardBossEntity.this)
                );
                PillagerWizardBossEntity.this.getWorld().emitGameEvent(
                        GameEvent.ENTITY_PLACE,
                        new Vec3d(x, blockPos.getY() + offset, z),
                        GameEvent.Emitter.of(PillagerWizardBossEntity.this)
                );
            }
        }

        @Override
        protected SoundEvent getSoundPrepare() {
            return SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON;
        }

        @Override
        protected SpellcastingIllagerEntity.Spell getSpell() {
            return Spell.FANGS;
        }
    }

    // Vanilla-like inner class for snowball projectile
    class ThrowSnowballSpellGoal extends CastSpellGoal {
        @Override
        protected int getSpellTicks() {
            return 20; // Duration of the spell casting
        }

        @Override
        protected int startTimeDelay() {
            return 40; // Delay before the spell starts
        }

        @Override
        protected void castSpell() {
            // Set the animation for the snowball throw.
            PillagerWizardBossEntity.this.setSpell(SpellcastingIllagerEntity.Spell.SUMMON_VEX);
            LivingEntity target = PillagerWizardBossEntity.this.getTarget();
            if (target != null) {
                DamagingSnowballEntity snowball = new DamagingSnowballEntity(PillagerWizardBossEntity.this.getWorld(), PillagerWizardBossEntity.this);
                snowball.setPosition(PillagerWizardBossEntity.this.getX(),
                        PillagerWizardBossEntity.this.getEyeY() - 0.1,
                        PillagerWizardBossEntity.this.getZ());

                double dx = target.getX() - PillagerWizardBossEntity.this.getX();
                double dy = target.getBodyY(0.5) - PillagerWizardBossEntity.this.getEyeY();
                double dz = target.getZ() - PillagerWizardBossEntity.this.getZ();
                float velocity = 1.5F;
                float inaccuracy = 0.0F;
                snowball.setVelocity(dx, dy, dz, velocity, inaccuracy);

                PillagerWizardBossEntity.this.getWorld().spawnEntity(snowball);
            }
        }

        @Override
        protected SoundEvent getSoundPrepare() {
            return null;
        }

        @Override
        protected SpellcastingIllagerEntity.Spell getSpell() {
            // Use an appropriate built-in spell type.
            return Spell.SUMMON_VEX;
        }
    }

}