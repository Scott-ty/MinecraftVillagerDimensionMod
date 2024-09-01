package net.scott.minecraftvillagerdimensionmod;

import net.fabricmc.api.ModInitializer;

import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.item.Items;
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

		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.EMERALD_TORCH)
				.lightWithItem(Items.FLINT_AND_STEEL)
				.destDimID(Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "dim"))
				.tintColor(0x00674F)
				.flatPortal()
				.registerPortal();
	}
}