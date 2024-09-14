package net.scott.minecraftvillagerdimensionmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.scott.minecraftvillagerdimensionmod.datagen.*;
import net.scott.minecraftvillagerdimensionmod.world.ModConfiguredFeatures;
import net.scott.minecraftvillagerdimensionmod.world.ModPlacedFeatures;
import net.scott.minecraftvillagerdimensionmod.world.biome.ModBiomes;
import net.scott.minecraftvillagerdimensionmod.world.dimension.ModDimensions;

public class MinecraftVillagerDimensionModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModWorldGenerator::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModAdvancementsProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder){
		registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, ModDimensions::bootstrapType);
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);
	}
}
