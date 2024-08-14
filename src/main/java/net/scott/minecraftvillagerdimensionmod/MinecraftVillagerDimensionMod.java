package net.scott.minecraftvillagerdimensionmod;

import net.fabricmc.api.ModInitializer;

import net.scott.minecraftvillagerdimensionmod.item.ModItemGroups;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinecraftVillagerDimensionMod implements ModInitializer {
	public static final String MOD_ID = "minecraftvillagerdimensionmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}