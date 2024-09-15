package net.scott.minecraftvillagerdimensionmod.world.dimension;


import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.dimension.DimensionTypes;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;

import java.util.OptionalLong;

public class ModDimensions {

    public static final RegistryKey<DimensionOptions> DIMOP_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "dim"));
    public static final RegistryKey<World> DIMW_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "dim"));
    public static final RegistryKey<DimensionType> DIM_KEY_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "dim_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(DIM_KEY_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY, was 0
                320, // height, was 256
                320, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
    }
}
