package net.scott.minecraftvillagerdimensionmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.entity.custom.OrangeKoiFishEntity;

public class ModEntities {
    public static final EntityType<OrangeKoiFishEntity> ORANGE_KOI_FISH = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "root"),
            EntityType.Builder.create(OrangeKoiFishEntity::new, SpawnGroup.WATER_AMBIENT).dimensions(.5f, .5f).build());
}
