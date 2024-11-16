package net.scott.minecraftvillagerdimensionmod.world;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateSupplier;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.NoiseBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.UpwardsBranchingTrunkPlacer;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;

import java.util.Arrays;
import java.util.List;

public class ModConfiguredFeatures {

    // Ore Generation
    public static final RegistryKey<ConfiguredFeature<?,?>> ANCIENT_GEMSTONE_ORE_KEY = registerKey("ancient_gemstone_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> MAGICITE_ORE_KEY = registerKey("magicite_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> PILLAGERITE_ORE_KEY = registerKey("pillagerite_ore");

    // Tree Generation
    public static final RegistryKey<ConfiguredFeature<?,?>> ROWAN_KEY = registerKey("rowan");
    public static final RegistryKey<ConfiguredFeature<?,?>> JUNIPER_KEY = registerKey("juniper");
    public static final RegistryKey<ConfiguredFeature<?,?>> SYCAMORE_KEY = registerKey("sycamore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        // Replaces Ores that are in stone or deepslate
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // Replaces the different ores with the stone or deepslate state
        List<OreFeatureConfig.Target> overworldAncientGemstoneOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.ANCIENT_GEMSTONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_ANCIENT_GEMSTONE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldMagiciteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.MAGICITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_MAGICITE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldPillageriteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.PILLAGERITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_PILLAGERITE_ORE.getDefaultState()));

        // Change number to make the ores more rare
        register(context, ANCIENT_GEMSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldAncientGemstoneOres, 12));
        register(context, MAGICITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldMagiciteOres, 12));
        register(context, PILLAGERITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPillageriteOres, 12));


        RegistryEntryLookup<PlacedFeature> registryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        DoublePerlinNoiseSampler.NoiseParameters noiseParameters = new DoublePerlinNoiseSampler.NoiseParameters(0, 1.0);
        // Rowan Tree Growth
        register(context, ROWAN_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ROWAN_LOG),
                //This places the trunk. There are lots of different ones
                new StraightTrunkPlacer(4,2,1),

                new NoiseBlockStateProvider(3, noiseParameters, 3, Arrays.asList(
                        ModBlocks.ROWAN_LEAVES.getDefaultState(),
                        ModBlocks.ROWAN_BERRY_LEAVES.getDefaultState()
                )),
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

                new NoiseBlockStateProvider(3, noiseParameters, 3, Arrays.asList(
                        ModBlocks.JUNIPER_LEAVES.getDefaultState(),
                        ModBlocks.JUNIPER_BERRY_LEAVES.getDefaultState()
                )),
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
                new LargeOakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(3),2),
                //new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(4), ConstantIntProvider.create(3), 40),
                //new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(5),3),

                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    // These are needed for the base class of configured feature
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
