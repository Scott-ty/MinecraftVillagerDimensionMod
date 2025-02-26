package net.scott.minecraftvillagerdimensionmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

import java.util.EnumSet;
import java.util.Random;

public class MonarchButterfly extends FlyingEntity implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final Random RANDOM = new Random();


    // DataTracker to sync the texture
    private final Identifier butterflyTexture;
    public MonarchButterfly(EntityType<? extends FlyingEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new ButterflyMoveControl(this);
        this.butterflyTexture = selectRandomTexture();
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new RandomFlyGoal(this, 0.2F));
        //this.goalSelector.add(5, new WanderAroundGoal(this, 0.5F, 3));
        this.goalSelector.add(1, new SwimGoal(this));
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

    public static boolean isOnGroundPredicate(EntityType<MonarchButterfly> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, net.minecraft.util.math.random.Random random) {
        // Check if the block below the spawn position is a solid block.
        return world.getBlockState(pos.down()).isSolidBlock(world, pos.down());
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

    public class RandomFlyGoal extends Goal {
        private final MonarchButterfly butterfly;
        private final double speed;
        private final Random random = new Random();
        private Vec3d target;

        public RandomFlyGoal(MonarchButterfly butterfly, double speed) {
            this.butterfly = butterfly;
            this.speed = speed;
            this.setControls(EnumSet.of(Control.MOVE));
        }

        @Override
        public boolean canStart() {
            return !butterfly.getMoveControl().isMoving() && random.nextInt(10) == 0;
        }

        @Override
        public boolean shouldContinue() {
            return target != null && butterfly.getPos().distanceTo(target) > 0.5;
        }

        @Override
        public void start() {
            target = getRandomLocation();
            butterfly.getMoveControl().moveTo(target.x, target.y, target.z, speed);
        }

        private Vec3d getRandomLocation() {
            // Try up to 10 times to find a valid location
            for (int attempts = 0; attempts < 10; attempts++) {
                double x = butterfly.getX() + (random.nextDouble() * 10 - 5);
                double z = butterfly.getZ() + (random.nextDouble() * 10 - 5);

                double currentY = butterfly.getY();
                double worldBottom = butterfly.getWorld().getBottomY();
                double worldTop = butterfly.getWorld().getTopY();

                // Define safe vertical bounds
                double safeMinY = worldBottom + 20;  // e.g., at least 20 blocks above the bottom
                double safeMaxY = worldTop - 5;        // slightly below the top

                // Try to keep the new Y close to the current Y (±3), clamped to our safe boundaries
                double minY = Math.max(currentY - 3, safeMinY);
                double maxY = Math.min(currentY + 3, safeMaxY);
                if (minY > maxY) { // in case the range inverted
                    minY = safeMinY;
                    maxY = safeMinY + 6;
                }
                double y = minY + random.nextDouble() * (maxY - minY);

                Vec3d candidate = new Vec3d(x, y, z);
                // Check if the candidate location is in a non-solid block (air)
                if (butterfly.getWorld().getBlockState(new BlockPos((int) candidate.x, (int) candidate.y, (int) candidate.z)).isAir()) {
                    return candidate;
                }
            }
            // If no valid position is found after several attempts, return current position as fallback.
            return butterfly.getPos();
        }



    }


    class ButterflyMoveControl extends MoveControl {
        private final MonarchButterfly butterfly;

        public ButterflyMoveControl(MonarchButterfly butterfly) {
            super(butterfly);
            this.butterfly = butterfly;
        }

        @Override
        public void tick() {
            if (this.state == State.MOVE_TO) {
                Vec3d target = new Vec3d(this.targetX, this.targetY, this.targetZ);
                Vec3d direction = target.subtract(butterfly.getPos()).normalize();
                double speed = 0.05; // Slightly increase speed for more natural movement

                // Apply movement smoothly, allowing vertical movement
                butterfly.setVelocity(new Vec3d(direction.x * speed, direction.y * speed, direction.z * speed));

                // Only recalc rotation if the direction isn't near zero
                if (direction.lengthSquared() > 1e-6) {
                    // Calculate yaw: arctan2 returns radians; convert to degrees and adjust so 0 faces north
                    float newYaw = (float)(Math.atan2(direction.z, direction.x) * (180 / Math.PI)) - 90F;
                    // Calculate pitch: negative arctan2 of vertical vs horizontal component
                    float newPitch = (float)(-Math.atan2(direction.y, Math.sqrt(direction.x * direction.x + direction.z * direction.z)) * (180 / Math.PI));

                    butterfly.setYaw(newYaw);
                    butterfly.setPitch(newPitch);
                }

                // Stop moving when close to the target
                if (butterfly.getPos().distanceTo(target) < 0.5) {
                    this.state = State.WAIT;
                }
            }
        }
    }
}
