package net.scott.minecraftvillagerdimensionmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

import java.util.Random;

public class MonarchButterfly extends PathAwareEntity implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final Random RANDOM = new Random();

    // DataTracker to sync the texture
    private final Identifier butterflyTexture;
    public MonarchButterfly(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.butterflyTexture = selectRandomTexture();
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(4, new FlyGoal(this, 1));
        this.goalSelector.add(5, new WanderAroundGoal(this, 0.5F, 3));
        this.goalSelector.add(6, new SwimGoal(this));
    }

    public static DefaultAttributeContainer.Builder createMonarchButterflyAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3F)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0);
    }

    // Random texture selection logic with rarity weights
    private Identifier selectRandomTexture() {
        Identifier[] textures = new Identifier[]{
                Identifier.of("minecraftvillagerdimensionmod", "textures/entity/monarch_butterfly_texture.png"),      // Common
                Identifier.of("minecraftvillagerdimensionmod", "textures/entity/monarch_butterfly_texture_2.png"),    // Rare
                Identifier.of("minecraftvillagerdimensionmod", "textures/entity/monarch_butterfly_texture_3.png"),    // Epic
                Identifier.of("minecraftvillagerdimensionmod", "textures/entity/monarch_butterfly_texture_4.png")     // Legendary
        };

        int[] weights = {50, 30, 15, 4}; // Rarity distribution
        int totalWeight = 0;

        for (int weight : weights) {
            totalWeight += weight;
        }

        int randomValue = RANDOM.nextInt(totalWeight);
        for (int i = 0; i < weights.length; i++) {
            if (randomValue < weights[i]) {
                return textures[i];
            }
            randomValue -= weights[i];
        }

        return textures[0]; // Fallback to common
    }

    @Nullable
    public Identifier getButterflyTexture() {
        return this.butterflyTexture;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<GeoAnimatable>(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("flying", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
