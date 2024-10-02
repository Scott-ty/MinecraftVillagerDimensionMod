package net.scott.minecraftvillagerdimensionmod.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;

public class ModModelLayers {
    public static final EntityModelLayer ORANGE_KOI_FISH = new EntityModelLayer(Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "orange_koi_fish"), "main");
    public static final EntityModelLayer WHITE_KOI_FISH = new EntityModelLayer(Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "white_koi_fish"), "main");
    public static final EntityModelLayer BLACK_KOI_FISH = new EntityModelLayer(Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "black_koi_fish"), "main");
}
