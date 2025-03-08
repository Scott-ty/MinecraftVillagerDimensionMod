package net.scott.minecraftvillagerdimensionmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import java.util.Random;

public class PillagerBruteBossEntity extends PillagerEntity implements GeoEntity {
    // Special attack chance at 30%
    private static final float SPECIAL_ATTACK_CHANCE = 0.3f; // 30% chance

    // This does not work for loot tables
    public static final RegistryKey<LootTable> LOOT_TABLE_KEY = RegistryKey.of(
            RegistryKeys.LOOT_TABLE,
            //RegistryKey.ofRegistry(Identifier.of("minecraft", "loot_table/entities")),
            Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "entities/buffpillager")
    );

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private ServerBossBar bossBar = null;
    public PillagerBruteBossEntity(EntityType<? extends PillagerEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = new ServerBossBar(
                Text.literal("Gronk The Manly"), // Boss bar title
                ServerBossBar.Color.RED,           // Boss bar color
                ServerBossBar.Style.PROGRESS       // Boss bar style
        );
    }

    public static DefaultAttributeContainer.Builder createPillagerBruteBossAttributes() {
        return PillagerEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 250)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f)
                .add(EntityAttributes.GENERIC_ARMOR, 3.0f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this)); //HAS to be primary goal or entity will drown lol
        this.goalSelector.add(1, new WanderAroundPointOfInterestGoal(this, 0.5F, false));
        this.goalSelector.add(2, new LookAroundGoal(this));
        //this.goalSelector.add(2, new WanderAroundGoal(this, 0.5F, 15));

        //racism is fun - I'm keeping this
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, VillagerEntity.class, true));
        this.goalSelector.add(4, new MeleeAttackGoal(this,0.5F, true));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<GeoAnimatable>(this, "controller", 0, this::predicate));
        controllers.add(new AnimationController<GeoAnimatable>(this, "attackcontroller", 0, this::attackpredicate));
    }

    // For attack animation
    private PlayState attackpredicate(AnimationState<GeoAnimatable> tAnimationState) {
        if (this.handSwinging && tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            // Check if health is below half
            if (this.getHealth() < this.getMaxHealth() / 2) {
                // Roll for special attack chance
                if (new Random().nextFloat() < SPECIAL_ATTACK_CHANCE) {
                    tAnimationState.getController().forceAnimationReset();
                    tAnimationState.getController().setAnimationSpeed(1.5F); // Adjust speed as needed
                    tAnimationState.getController().setAnimation(RawAnimation.begin().then("jump smash", Animation.LoopType.PLAY_ONCE));
                } else {
                    // Perform basic attack
                    tAnimationState.getController().forceAnimationReset();
                    tAnimationState.getController().setAnimationSpeed(2.0F);
                    tAnimationState.getController().setAnimation(RawAnimation.begin().then("basic attack", Animation.LoopType.PLAY_ONCE));
                }
            } else {
                // Perform basic attack
                tAnimationState.getController().forceAnimationReset();
                tAnimationState.getController().setAnimationSpeed(2.0F);
                tAnimationState.getController().setAnimation(RawAnimation.begin().then("basic attack", Animation.LoopType.PLAY_ONCE));
            }
            this.handSwinging = false;
        }
        return PlayState.CONTINUE;
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false; // Prevents natural despawning
    }

    // For basic walk animation
    private PlayState predicate(AnimationState<GeoAnimatable> tAnimationState) {
        if(tAnimationState.isMoving()){
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        tAnimationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    // Mostly for the boss bar
    @Override
    public void tick() {
        super.tick();

        // Update boss bar percentage
        if (!this.getWorld().isClient && this.isAlive()) {
            this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
        }
    }
    // For the boss bar
    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player); // Add player to boss bar
    }
    // For the boss bar
    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player); // Remove player from boss bar
    }

    @Override
    protected RegistryKey<LootTable> getLootTableId() {
        return LOOT_TABLE_KEY;
    }
}
