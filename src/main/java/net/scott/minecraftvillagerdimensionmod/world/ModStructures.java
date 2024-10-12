package net.scott.minecraftvillagerdimensionmod.world;

import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;
import net.scott.minecraftvillagerdimensionmod.world.structure.LargeKoiPondStructure;

public class ModStructures {
    public static final RegistryKey<Structure> LARGE_KOI_POND_KEY =
            RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of("minecraftvillagerdimensionmod", "large_koi_pond"));

    // Register the structure type
    public static final StructureType<LargeKoiPondStructure> LARGE_KOI_POND_TYPE =
            register("large_koi_pond", LargeKoiPondStructure.CODEC);

    //public static void registerStructures() {
        // Register the structure in the registry
       // Registry.register(RegistryKeys.STRUCTURE, LARGE_KOI_POND_KEY.getValue(), LARGE_KOI_POND_TYPE);
   // }

    private static <T extends Structure> StructureType<T> register(String id, MapCodec<T> codec) {
        return Registry.register(Registries.STRUCTURE_TYPE, Identifier.of("minecraftvillagerdimensionmod", id), () -> codec);
    }

    public static void registerStructures() {
    }
}
