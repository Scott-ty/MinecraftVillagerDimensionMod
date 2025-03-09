package net.scott.minecraftvillagerdimensionmod.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
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
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

public class PillagerWizardBossEntity extends SpellcastingIllagerEntity implements GeoEntity {
    private static final float SPECIAL_ATTACK_CHANCE = 0.3f;
    private static final float CHANT_ATTACK_CHANCE = 0.25f;

    // Tracked data for animation states
    private static final TrackedData<String> SPELL_ANIMATION =
            DataTracker.registerData(PillagerWizardBossEntity.class, TrackedDataHandlerRegistry.STRING);

    private static final TrackedData<Boolean> ANIMATION_TRIGGERED =
            DataTracker.registerData(PillagerWizardBossEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private int animationClearTimer = 0;

    // Loot table and GeckoLib setup
    public static final RegistryKey<LootTable> LOOT_TABLE_KEY = RegistryKey.of(
            RegistryKeys.LOOT_TABLE,
            Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "entities/wizardpillager")
    );
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final ServerBossBar bossBar;

    public PillagerWizardBossEntity(EntityType<? extends SpellcastingIllagerEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = new ServerBossBar(
                Text.literal("Mortvax The Chaotic"),
                ServerBossBar.Color.BLUE,
                ServerBossBar.Style.PROGRESS
        );
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(SPELL_ANIMATION, "");
        builder.add(ANIMATION_TRIGGERED, false);
    }

    public static DefaultAttributeContainer.Builder createPillagerWizardBossAttributes() {
        return PillagerEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 250)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f)
                .add(EntityAttributes.GENERIC_ARMOR, 3.0f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15);
    }

    @Override
    protected void initGoals() {
        this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, VillagerEntity.class, true));
        this.goalSelector.add(2, new ThrowSnowballSpellGoal());
        this.goalSelector.add(3, new SummonFangsGoal());
        this.goalSelector.add(4, new MeleeAttackGoal(this, 0.6F, true));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 12.0F));
        this.goalSelector.add(7, new FleeEntityGoal<>(this, PlayerEntity.class, 10.0F, 0.5F, 0.8F));
        this.goalSelector.add(8, new WanderAroundGoal(this, 0.3F, 20));
    }

    @Override
    public void registerControllers(software.bernie.geckolib.animation.AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
        controllers.add(new AnimationController<>(this, "attackcontroller", 5, this::attackpredicate));
    }

    // Animation logic
    private PlayState attackpredicate(AnimationState<software.bernie.geckolib.animatable.GeoAnimatable> tAnimationState) {
        String spellAnim = this.dataTracker.get(SPELL_ANIMATION);
        boolean isTriggered = this.dataTracker.get(ANIMATION_TRIGGERED);
        tAnimationState.getController().setAnimationSpeed(1.1f);
        if (!isTriggered && (this.handSwinging || !spellAnim.isEmpty())
                && tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {

            if (this.handSwinging) {
                tAnimationState.getController().setAnimation(
                        RawAnimation.begin().then("animation.model.swing", Animation.LoopType.PLAY_ONCE)
                );
                System.out.println("Playing Swing animation");
                scheduleFlagClear(getAnimationDuration("animation.model.swing"));
            } else if (!spellAnim.isEmpty()) {
                tAnimationState.getController().setAnimation(
                        RawAnimation.begin().then(spellAnim, Animation.LoopType.PLAY_ONCE)
                );
                System.out.println("Playing Spell animation");
                scheduleFlagClear(getAnimationDuration(spellAnim));
            }

            this.dataTracker.set(ANIMATION_TRIGGERED, true);
            return PlayState.CONTINUE;
        }
        return PlayState.CONTINUE;
    }

    private PlayState predicate(AnimationState<software.bernie.geckolib.animatable.GeoAnimatable> tAnimationState) {
        if (isHeSpellcasting()) {
            return PlayState.STOP;
        }
        if (tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(
                    RawAnimation.begin().then("animation.model.walk", Animation.LoopType.LOOP)
            );
        } else {
            tAnimationState.getController().setAnimation(
                    RawAnimation.begin().then("animation.model.idle", Animation.LoopType.LOOP)
            );
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.getWorld().isClient) {
            if (animationClearTimer > 0) {
                animationClearTimer--;
                System.out.println("Timer: " + animationClearTimer);
            }
            if (this.animationClearTimer <= 0 && this.dataTracker.get(ANIMATION_TRIGGERED)) {
                this.dataTracker.set(SPELL_ANIMATION, "");
                this.dataTracker.set(ANIMATION_TRIGGERED, false);
                System.out.println("Flags reset!"); //
            }
        }
        if (!this.getWorld().isClient && this.isAlive()) {
            this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
        }
    }

    private boolean isHeSpellcasting() {
        return this.handSwinging || !this.dataTracker.get(SPELL_ANIMATION).isEmpty();
    }

    private int getAnimationDuration(String anim) {
        switch (anim) {
            case "animation.model.swing": return 30;
            case "animation.model.launch_projectile": return 45;
            case "animation.model.chant": return 65;
            default: return 20;
        }
    }

    private void scheduleFlagClear(int ticks) {
        this.animationClearTimer = ticks;
    }

    // Spellcasting goals
    class SummonFangsGoal extends CastSpellGoal {
        @Override
        protected void castSpell() {
            PillagerWizardBossEntity.this.dataTracker.set(SPELL_ANIMATION, "animation.model.chant");
            scheduleFlagClear(getAnimationDuration("animation.model.chant"));

            // Original spellcasting logic
            LivingEntity target = getTarget();
            double d = Math.min(target.getY(), getY());
            double e = Math.max(target.getY(), getY()) + 1.0;
            float f = (float)MathHelper.atan2(target.getZ() - getZ(), target.getX() - getX());

            if (squaredDistanceTo(target) < 9.0) {
                for (int i = 0; i < 5; ++i) {
                    float g = f + (float)i * (float)Math.PI * 0.4f;
                    conjureFangs(getX() + MathHelper.cos(g) * 1.5, getZ() + MathHelper.sin(g) * 1.5, d, e, g, 0);
                }
                for (int i = 0; i < 8; ++i) {
                    float g = f + (float)i * (float)Math.PI * 2.0f / 8.0f + 1.2566371f;
                    conjureFangs(getX() + MathHelper.cos(g) * 2.5, getZ() + MathHelper.sin(g) * 2.5, d, e, g, 3);
                }
            } else {
                for (int i = 0; i < 16; ++i) {
                    double h = 1.25 * (double)(i + 1);
                    conjureFangs(getX() + MathHelper.cos(f) * h, getZ() + MathHelper.sin(f) * h, d, e, f, i);
                }
            }
        }

        private void conjureFangs(double x, double z, double maxY, double y, float yaw, int warmup) {
            BlockPos blockPos = BlockPos.ofFloored(x, y, z);
            boolean foundSolid = false;
            double offset = 0.0;

            do {
                BlockState blockState = getWorld().getBlockState(blockPos.down());
                if (blockState.isSideSolidFullSquare(getWorld(), blockPos.down(), Direction.UP)) {
                    if (!getWorld().isAir(blockPos)) {
                        VoxelShape voxelShape = getWorld().getBlockState(blockPos).getCollisionShape(getWorld(), blockPos);
                        if (!voxelShape.isEmpty()) offset = voxelShape.getMax(Direction.Axis.Y);
                    }
                    foundSolid = true;
                    break;
                }
                blockPos = blockPos.down();
            } while(blockPos.getY() >= MathHelper.floor(maxY) - 1);

            if (foundSolid) {
                getWorld().spawnEntity(new EvokerFangsEntity(getWorld(), x, blockPos.getY() + offset, z, yaw, warmup, PillagerWizardBossEntity.this));
                getWorld().emitGameEvent(GameEvent.ENTITY_PLACE, new Vec3d(x, blockPos.getY() + offset, z), GameEvent.Emitter.of(PillagerWizardBossEntity.this));
            }
        }

        @Override protected int getSpellTicks() { return 60; }
        @Override protected int startTimeDelay() { return 45; }
        @Override protected SoundEvent getSoundPrepare() { return SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON; }
        @Override protected Spell getSpell() { return Spell.SUMMON_VEX; }
    }

    class ThrowSnowballSpellGoal extends CastSpellGoal {
        @Override
        protected void castSpell() {
            PillagerWizardBossEntity.this.dataTracker.set(SPELL_ANIMATION, "animation.model.launch_projectile");
            scheduleFlagClear(getAnimationDuration("animation.model.launch_projectile"));

            LivingEntity target = getTarget();
            if (target != null) {
                DamagingSnowballEntity snowball = new DamagingSnowballEntity(getWorld(), PillagerWizardBossEntity.this);
                snowball.setPosition(getX(), getEyeY() - 0.1, getZ());
                double dx = target.getX() - getX();
                double dy = target.getBodyY(0.5) - getEyeY();
                double dz = target.getZ() - getZ();
                snowball.setVelocity(dx, dy, dz, 1.5f, 0.0f);
                getWorld().spawnEntity(snowball);
            }
        }

        @Override protected int getSpellTicks() { return 40; }
        @Override protected int startTimeDelay() { return 30; }
        @Override protected SoundEvent getSoundPrepare() { return null; }
        @Override protected Spell getSpell() { return Spell.FANGS; }
    }

    // Remaining methods
    @Override public AnimatableInstanceCache getAnimatableInstanceCache() { return cache; }
    @Override protected SoundEvent getCastSpellSound() { return SoundEvents.ENTITY_EVOKER_CAST_SPELL; }
    @Override public void onStartedTrackingBy(ServerPlayerEntity player) { super.onStartedTrackingBy(player); bossBar.addPlayer(player); }
    @Override public void onStoppedTrackingBy(ServerPlayerEntity player) { super.onStoppedTrackingBy(player); bossBar.removePlayer(player); }
    @Override protected RegistryKey<LootTable> getLootTableId() { return LOOT_TABLE_KEY; }
    @Override public void addBonusForWave(ServerWorld world, int wave, boolean unused) {}
    @Override public SoundEvent getCelebratingSound() { return null; }
}