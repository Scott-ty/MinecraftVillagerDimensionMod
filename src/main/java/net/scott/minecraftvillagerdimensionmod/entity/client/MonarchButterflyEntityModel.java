package net.scott.minecraftvillagerdimensionmod.entity.client;

import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.entity.custom.MonarchButterfly;
import net.scott.minecraftvillagerdimensionmod.entity.custom.PillagerBruteBossEntity;
import software.bernie.geckolib.model.GeoModel;

import java.util.Random;

public class MonarchButterflyEntityModel extends GeoModel<MonarchButterfly> {
    private static final java.util.Random RANDOM = new Random();

    @Override
    public Identifier getModelResource(MonarchButterfly animatable) {
        return Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "geo/monarch_butterfly.geo.json");
    }

    @Override
    public Identifier getTextureResource(MonarchButterfly animatable) {
        // Retrieve the texture from the MonarchButterfly entity
        Identifier texture = animatable.getButterflyTexture();

        // If the butterfly doesn't have a texture (shouldn't happen in normal flow)
        if (texture == null) {
            // Fallback texture (if necessary)
            texture = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "textures/entity/monarch_butterfly_texture.png");
        }

        return texture;
    }

    @Override
    public Identifier getAnimationResource(MonarchButterfly animatable) {
        return Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "animations/monarch_butterfly.animation.json");
    }
}
