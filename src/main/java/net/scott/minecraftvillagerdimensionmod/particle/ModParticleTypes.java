package net.scott.minecraftvillagerdimensionmod.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;

public class ModParticleTypes {

    public static final SimpleParticleType EMERALD_FLAME = registerParticles("emerald_flame", FabricParticleTypes.simple());

    public static SimpleParticleType registerParticles(String name, SimpleParticleType particleTypes){
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, name), particleTypes);
    }

    public static void registerParticles(){

    }
}
