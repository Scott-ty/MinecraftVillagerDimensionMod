package net.scott.minecraftvillagerdimensionmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.scott.minecraftvillagerdimensionmod.world.ModPlacedFeatures;
import net.scott.minecraftvillagerdimensionmod.world.biome.ModBiomes;


public class ModOreGeneration {
    public static void generateOres(){
        // Places Ores into my biomes
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.VILLAGER_BIOME),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ANCIENT_GEMSTONE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CONTESTED_BIOME),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.MAGICITE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.PILLAGER_BIOME),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.PILLAGERITE_ORE_PLACED_KEY);
    }
}
