package net.scott.minecraftvillagerdimensionmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
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

public class EvilVillagerBossEntity extends PillagerEntity implements GeoEntity {

    // For Villager and Evil State
    private boolean isEvil = false;
    private AnimationController<GeoAnimatable> transformationController;

    // For loot table
    public static final RegistryKey<LootTable> LOOT_TABLE_KEY = RegistryKey.of(
            RegistryKeys.LOOT_TABLE,
            Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "entities/evilvillager")
    );

    // For animations
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    // For Boss Bar
    private ServerBossBar bossBar = null;

    // Super Function
    public EvilVillagerBossEntity(EntityType<? extends PillagerEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = new ServerBossBar(
                Text.literal("Evil Villager Boss"), // Boss bar title
                ServerBossBar.Color.GREEN,           // Boss bar color
                ServerBossBar.Style.PROGRESS       // Boss bar style
        );
    }

    // Standard Attributes Class
    public static DefaultAttributeContainer.Builder createEvilVillagerBossAttributes() {
        return PillagerEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f)
                .add(EntityAttributes.GENERIC_ARMOR, 3.0f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 13);
    }

    // Goals Class
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new WanderAroundPointOfInterestGoal(this, 0.5F, false));
        this.goalSelector.add(2, new LookAroundGoal(this));

        // Transform when targeting a player
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, true));

        // Villager state actions
        if (!isEvil) {
            this.goalSelector.add(4, new WanderAroundGoal(this, 0.5F, 15));
        }
        if (isEvil) {
            this.goalSelector.add(4, new MeleeAttackGoal(this, 0.5F, true));
            this.targetSelector.add(5, new ActiveTargetGoal<>(this, VillagerEntity.class, true));
        }
    }

    // Method to trigger evil transformation
    private boolean triggerTransformation(LivingEntity target) {
        if (!isEvil && target instanceof PlayerEntity) {
            isEvil = true;

            if (transformationController != null) {
                transformationController.forceAnimationReset();
                transformationController.setAnimation(RawAnimation.begin().then("animation.model.evil_transform", Animation.LoopType.PLAY_ONCE));
            }

            // Update AI goals
            this.goalSelector.getGoals().clear();
            this.initGoals();

            return true;
        }
        return false;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<GeoAnimatable>(this, "controller", 0, this::predicate));
        controllers.add(new AnimationController<GeoAnimatable>(this, "attackcontroller", 0, this::attackpredicate));
        transformationController = new AnimationController<>(this, "transformcontroller", 0, this::transformationPredicate);
        controllers.add(transformationController);
    }

    private PlayState transformationPredicate(AnimationState<GeoAnimatable> tAnimationState) {
        if (isEvil) {
            return PlayState.STOP;
        }

        tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.evil_transform", Animation.LoopType.PLAY_ONCE));
        return PlayState.CONTINUE;
    }

    // For attack animation
    private PlayState attackpredicate(AnimationState<GeoAnimatable> tAnimationState) {
        if (this.handSwinging && tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            this.handSwinging = false;

            if (isEvil) {
                tAnimationState.getController().forceAnimationReset();
                tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.attack_evil", Animation.LoopType.PLAY_ONCE));
            }
        }
        return PlayState.CONTINUE;
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false; // Prevents natural despawning
    }


    // For Walk and Idle
    private PlayState predicate(AnimationState<GeoAnimatable> tAnimationState) {
        if (isEvil) {
            if (tAnimationState.isMoving()) {
                tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.walk_evil", Animation.LoopType.LOOP));
            } else {
                tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.idle_evil", Animation.LoopType.LOOP));
            }
        } else {
            if (tAnimationState.isMoving()) {
                tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.villager_walk", Animation.LoopType.LOOP));
            } else {
                tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.villager_idle", Animation.LoopType.LOOP));
            }
        }
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

        if (!isEvil) {
            for (PlayerEntity player : this.getWorld().getPlayers()) {
                if (this.squaredDistanceTo(player) < 9) { // 3-block radius
                    triggerTransformation(player);
                    break;
                }
            }
        }

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
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        if (!this.getWorld().isClient) {
            this.bossBar.clearPlayers();
        }
    }
    // For loot table
    @Override
    protected RegistryKey<LootTable> getLootTableId() {
        return LOOT_TABLE_KEY;
    }
}
