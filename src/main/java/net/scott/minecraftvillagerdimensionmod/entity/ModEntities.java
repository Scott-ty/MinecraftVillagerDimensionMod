package net.scott.minecraftvillagerdimensionmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.entity.custom.BlackKoiFishEntity;
import net.scott.minecraftvillagerdimensionmod.entity.custom.OrangeKoiFishEntity;
import net.scott.minecraftvillagerdimensionmod.entity.custom.PillagerBruteBossEntity;
import net.scott.minecraftvillagerdimensionmod.entity.custom.WhiteKoiFishEntity;

public class ModEntities {
    public static final EntityType<OrangeKoiFishEntity> ORANGE_KOI_FISH = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "root"),
            EntityType.Builder.create(OrangeKoiFishEntity::new, SpawnGroup.WATER_AMBIENT).dimensions(.5f, .5f).build("root"));

    public static final EntityType<WhiteKoiFishEntity> WHITE_KOI_FISH = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "root2"),
            EntityType.Builder.create(WhiteKoiFishEntity::new, SpawnGroup.WATER_AMBIENT).dimensions(.5f, .5f).build("root2"));

    public static final EntityType<BlackKoiFishEntity> BLACK_KOI_FISH = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "root3"),
            EntityType.Builder.create(BlackKoiFishEntity::new, SpawnGroup.WATER_AMBIENT).dimensions(.5f, .5f).build("root3"));

    public static final EntityType<PillagerBruteBossEntity> PILLAGER_BRUTE_BOSS = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "buffpillager"),
            EntityType.Builder.create(PillagerBruteBossEntity::new, SpawnGroup.MISC).dimensions(1.5f, 3.5f).build("buffpillager"));
}
