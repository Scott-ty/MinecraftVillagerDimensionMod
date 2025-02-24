package net.scott.minecraftvillagerdimensionmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.entity.ModBoats;
import net.scott.minecraftvillagerdimensionmod.entity.ModEntities;
import net.scott.minecraftvillagerdimensionmod.entity.custom.*;
import net.scott.minecraftvillagerdimensionmod.item.ModItemGroups;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;
import net.scott.minecraftvillagerdimensionmod.particle.ModParticleTypes;
import net.scott.minecraftvillagerdimensionmod.processor.NoWaterProcessor;
import net.scott.minecraftvillagerdimensionmod.world.biome.ModBiomes;
import net.scott.minecraftvillagerdimensionmod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinecraftVillagerDimensionMod implements ModInitializer {
	public static final String MOD_ID = "minecraftvillagerdimensionmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final StructureProcessorType<NoWaterProcessor> NO_WATER_PROCESSOR =
			() -> NoWaterProcessor.CODEC;

	@Override
	public void onInitialize() {

		Registry.register(Registries.STRUCTURE_PROCESSOR, Identifier.of(MOD_ID, "no_water_processor"), NO_WATER_PROCESSOR);
		LOGGER.info("Custom processor registered: minecraftvillagerdimensionmod:no_water_processor");

		// Debug: Check if the processor is in the registry
		StructureProcessorType<?> processor = Registries.STRUCTURE_PROCESSOR.get(Identifier.of(MOD_ID, "no_water_processor"));
		if (processor != null) {
			LOGGER.info("Processor found in registry: {}", processor);
		} else {
			LOGGER.error("Processor NOT found in registry!");
		}
		//Mod Registering
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModParticleTypes.registerParticles();

		// ROWAN WOOD
		StrippableBlockRegistry.register(ModBlocks.ROWAN_LOG, ModBlocks.STRIPPED_ROWAN_LOG);
		StrippableBlockRegistry.register(ModBlocks.ROWAN_WOOD, ModBlocks.STRIPPED_ROWAN_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ROWAN_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ROWAN_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ROWAN_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ROWAN_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ROWAN_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ROWAN_LEAVES, 30, 60);

		// JUNIPER WOOD
		StrippableBlockRegistry.register(ModBlocks.JUNIPER_LOG, ModBlocks.STRIPPED_JUNIPER_LOG);
		StrippableBlockRegistry.register(ModBlocks.JUNIPER_WOOD, ModBlocks.STRIPPED_JUNIPER_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.JUNIPER_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.JUNIPER_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_JUNIPER_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_JUNIPER_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.JUNIPER_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.JUNIPER_LEAVES, 30, 60);

		// SYCAMORE WOOD
		StrippableBlockRegistry.register(ModBlocks.SYCAMORE_LOG, ModBlocks.STRIPPED_SYCAMORE_LOG);
		StrippableBlockRegistry.register(ModBlocks.SYCAMORE_WOOD, ModBlocks.STRIPPED_SYCAMORE_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SYCAMORE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SYCAMORE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_SYCAMORE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_SYCAMORE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SYCAMORE_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SYCAMORE_LEAVES, 30, 60);

		// Register ModBoats Java Class
		ModBoats.registerBoats();


		// Register Koi Fish
		FabricDefaultAttributeRegistry.register(ModEntities.ORANGE_KOI_FISH, OrangeKoiFishEntity.createOrangeKoiFishAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.WHITE_KOI_FISH, WhiteKoiFishEntity.createWhiteKoiFishAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.BLACK_KOI_FISH, BlackKoiFishEntity.createBlackKoiFishAttributes());
		// Brute Pillager Boss
		FabricDefaultAttributeRegistry.register(ModEntities.PILLAGER_BRUTE_BOSS, PillagerBruteBossEntity.createPillagerBruteBossAttributes());
		// Monarch Butterfly
		FabricDefaultAttributeRegistry.register(ModEntities.MONARCHBUTTERFLY, MonarchButterfly.createMonarchButterflyAttributes());

		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.EMERALD_BLOCK)
				.flatPortal()
				.lightWithWater()
				// Custom item to light the portal??
				// Could get it from a villager trade or something.
				.destDimID(Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "dim"))
				.tintColor(0x00674F)
				.registerPortal();


		// Generates Ore
		ModWorldGeneration.generateModWorldGen();
		ModBlocks.registerModBlocks();

	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}