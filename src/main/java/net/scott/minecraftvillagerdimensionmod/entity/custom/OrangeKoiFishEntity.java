package net.scott.minecraftvillagerdimensionmod.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.SwimAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;

public class OrangeKoiFishEntity extends FishEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public OrangeKoiFishEntity(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick(){
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = this.random.nextInt(10) + 20;
            this.idleAnimationState.start(this.age);
        }else{
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateLimbs(float posDelta){
        float f = this.getPose() == EntityPose.SWIMMING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 1f);
    }


    public static DefaultAttributeContainer.Builder createOrangeKoiFishAttributes(){
        return FishEntity.createFishAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new EscapeDangerGoal(this, 1.25));
        this.goalSelector.add(2, new FleeEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.6, 1.4, EntityPredicates.EXCEPT_SPECTATOR::test));
        this.goalSelector.add(4, new SwimAroundGoal(this, 5, 5));
    }

    // Add Salmon sound effects
    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_SALMON_FLOP;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SALMON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SALMON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SALMON_DEATH;
    }

    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(ModItems.ORANGE_KOI_BUCKET);
    }
}
