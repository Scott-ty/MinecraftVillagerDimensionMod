package net.scott.minecraftvillagerdimensionmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class DamagingSnowballEntity extends SnowballEntity {
    // This multiplier will make the snowball deal more damage than a normal one.
    private static final float DAMAGE_MULTIPLIER = 5.0f;

    public DamagingSnowballEntity(EntityType<? extends SnowballEntity> entityType, World world) {
        super(entityType, world);
    }

    public DamagingSnowballEntity(World world, LivingEntity owner) {
        // Note: Using the default SNOWBALL EntityType.
        super(EntityType.SNOWBALL, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult hitResult) {
        super.onEntityHit(hitResult);
        // Only run on the server side.
        if (!this.getWorld().isClient) {
            if (hitResult.getEntity() instanceof LivingEntity) {
                RegistryEntry<DamageType> thrownDamageType = this.getWorld()
                        .getRegistryManager()
                        .get(RegistryKeys.DAMAGE_TYPE)
                        .getEntry(DamageTypes.THROWN)
                        .orElseThrow(() -> new IllegalStateException("Thrown damage type missing"));
                // Create an indirect damage source with a damage type string ("thrown") that suits your needs.
                DamageSource damageSource = new DamageSource(thrownDamageType, this, this.getOwner());
                hitResult.getEntity().damage(damageSource, DAMAGE_MULTIPLIER);
            }
            this.discard();
        }
    }
}
