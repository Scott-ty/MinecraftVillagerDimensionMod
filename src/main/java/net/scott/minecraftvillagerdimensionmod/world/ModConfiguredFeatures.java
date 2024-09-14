package net.scott.minecraftvillagerdimensionmod.world;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.UpwardsBranchingTrunkPlacer;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> ROWAN_KEY = registerKey("rowan");
    public static final RegistryKey<ConfiguredFeature<?,?>> JUNIPER_KEY = registerKey("juniper");
    public static final RegistryKey<ConfiguredFeature<?,?>> SYCAMORE_KEY = registerKey("sycamore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        RegistryEntryLookup<PlacedFeature> registryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);


        // Rowan Tree Growth
        register(context, ROWAN_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ROWAN_LOG),
                //This places the trunk. There are lots of different ones
                new StraightTrunkPlacer(4,2,1),

                BlockStateProvider.of(ModBlocks.ROWAN_LEAVES),
                // Also several styles of leaves
                // IntProvider radius, IntProvider offset, int height
                new LargeOakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2), 4),

                new TwoLayersFeatureSize(1,0,2)).build());

        // Rowan Tree Growth
        register(context, JUNIPER_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.JUNIPER_LOG),
                //This places the trunk. There are lots of different ones
                // int baseHeight, int firstRandomHeight, int secondRandomHeight
                new StraightTrunkPlacer(2,1,1),

                BlockStateProvider.of(ModBlocks.JUNIPER_LEAVES),
                // Also several styles of leaves
                // (IntProvider radius, IntProvider offset, IntProvider trunkHeight)
                //new SpruceFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
                new PineFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), ConstantIntProvider.create(3)),

                new TwoLayersFeatureSize(1,0,2)).build());

        // Rowan Tree Growth
        register(context, SYCAMORE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.SYCAMORE_LOG),
                //This places the trunk. There are lots of different ones
                // int baseHeight, int firstRandomHeight, int secondRandomHeight
                // int baseHeight,
                // int firstRandomHeight,
                // int secondRandomHeight,
                // IntProvider extraBranchSteps,
                // float placeBranchPerLogProbability,
                // IntProvider extraBranchLength,
                // RegistryEntryList<Block> canGrowThrough
                new UpwardsBranchingTrunkPlacer(
                        6,  // baseHeight
                        5,  // firstRandomHeight
                        6,  // secondRandomHeight
                        ConstantIntProvider.create(5),  // extraBranchSteps
                        0.45f,  // placeBranchPerLogProbability
                        ConstantIntProvider.create(2),  // extraBranchLength
                        context.getRegistryLookup(RegistryKeys.BLOCK).getOrThrow(TagKey.of(RegistryKeys.BLOCK, Identifier.of("minecraftvillagerdimensionmod", "sycamore_grow_through")))
                ),

                BlockStateProvider.of(ModBlocks.SYCAMORE_LEAVES),
                // Also several styles of leaves
                // (IntProvider radius, IntProvider offset, IntProvider trunkHeight)
                new LargeOakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(4),2),
                //new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(4), ConstantIntProvider.create(3), 40),
                //new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(5),3),

                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
