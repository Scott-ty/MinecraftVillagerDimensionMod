package net.scott.minecraftvillagerdimensionmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.item.ModItemGroups;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;
import net.scott.minecraftvillagerdimensionmod.particle.ModParticleTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinecraftVillagerDimensionMod implements ModInitializer {
	public static final String MOD_ID = "minecraftvillagerdimensionmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

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

		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.EMERALD_BLOCK)
				.flatPortal()
				.lightWithWater()
				// Custom item to light the portal??
				// Could get it from a villager trade or something.
				.destDimID(Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "dim"))
				.tintColor(0x00674F)
				.registerPortal();
	}
}