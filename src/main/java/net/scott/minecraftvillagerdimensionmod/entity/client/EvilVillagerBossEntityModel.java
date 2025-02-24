package net.scott.minecraftvillagerdimensionmod.entity.client;

import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.entity.custom.EvilVillagerBossEntity;
import software.bernie.geckolib.model.GeoModel;

public class EvilVillagerBossEntityModel extends GeoModel<EvilVillagerBossEntity> {

    @Override
    public Identifier getModelResource(EvilVillagerBossEntity animatable) {
        return Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "geo/evil_villager.geo.json");
    }

    @Override
    public Identifier getTextureResource(EvilVillagerBossEntity animatable) {
        return Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "textures/entity/evil_villager.png");

    }

    @Override
    public Identifier getAnimationResource(EvilVillagerBossEntity animatable) {
        return Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "animations/evil_villager.animation.json");

    }
}
