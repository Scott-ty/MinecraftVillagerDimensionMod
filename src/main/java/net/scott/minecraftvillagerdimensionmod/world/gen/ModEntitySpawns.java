package net.scott.minecraftvillagerdimensionmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;
import net.scott.minecraftvillagerdimensionmod.entity.ModEntities;
import net.scott.minecraftvillagerdimensionmod.entity.custom.MonarchButterfly;
import net.scott.minecraftvillagerdimensionmod.world.biome.ModBiomes;

public class ModEntitySpawns {
    public static void addSpawns(){
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.VILLAGER_BIOME), SpawnGroup.AMBIENT
                ,ModEntities.MONARCHBUTTERFLY, 50, 3, 10);

        SpawnRestriction.register(ModEntities.MONARCHBUTTERFLY, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonarchButterfly::isOnGroundPredicate);
    }
}
