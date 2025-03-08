package net.scott.minecraftvillagerdimensionmod.entity.client;

import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.entity.custom.PillagerWizardBossEntity;
import software.bernie.geckolib.model.GeoModel;

public class PillagerWizardBossEntityModel extends GeoModel<PillagerWizardBossEntity> {

    @Override
    public Identifier getModelResource(PillagerWizardBossEntity animatable) {
        return Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "geo/wizard_pillager.geo.json");
    }

    @Override
    public Identifier getTextureResource(PillagerWizardBossEntity animatable) {
        return Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "textures/entity/wizard_pillager.png");

    }

    @Override
    public Identifier getAnimationResource(PillagerWizardBossEntity animatable) {
        return Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "animations/wizard_pillager.animation.json");

    }
}
