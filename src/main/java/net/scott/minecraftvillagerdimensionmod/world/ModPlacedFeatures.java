package net.scott.minecraftvillagerdimensionmod.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {

    // Ore Gen Placed Features
    public static final RegistryKey<PlacedFeature> ANCIENT_GEMSTONE_ORE_PLACED_KEY = registerKey("ancient_gemstone_ore_placed");
    public static final RegistryKey<PlacedFeature> MAGICITE_ORE_PLACED_KEY = registerKey("magicite_ore_placed");
    public static final RegistryKey<PlacedFeature> PILLAGERITE_ORE_PLACED_KEY = registerKey("pillagerite_ore_placed");

    // Tree Gen Placed Features
    public static final RegistryKey<PlacedFeature> ROWAN_TREE_KEY = registerKey("rowan_tree");
    public static final RegistryKey<PlacedFeature> JUNIPER_TREE_KEY = registerKey("juniper_tree");
    public static final RegistryKey<PlacedFeature> SYCAMORE_TREE_KEY = registerKey("sycamore_tree");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?,?>> registryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // For ore generation
        register(context, ANCIENT_GEMSTONE_ORE_PLACED_KEY, registryLookup.getOrThrow(ModConfiguredFeatures.ANCIENT_GEMSTONE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2, // Veins per chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-20), YOffset.fixed(10))));
        register(context, MAGICITE_ORE_PLACED_KEY, registryLookup.getOrThrow(ModConfiguredFeatures.MAGICITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(3, // Veins per chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-20), YOffset.fixed(10))));
        register(context, PILLAGERITE_ORE_PLACED_KEY, registryLookup.getOrThrow(ModConfiguredFeatures.PILLAGERITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(3, // Veins per chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-20), YOffset.fixed(10))));

        // For tree generation
        register(context, ROWAN_TREE_KEY, registryLookup.getOrThrow(ModConfiguredFeatures.ROWAN_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.2f, 3),
                        ModBlocks.ROWAN_SAPLING));

        register(context, JUNIPER_TREE_KEY, registryLookup.getOrThrow(ModConfiguredFeatures.JUNIPER_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.2f, 3),
                        ModBlocks.JUNIPER_SAPLING));

        register(context, SYCAMORE_TREE_KEY, registryLookup.getOrThrow(ModConfiguredFeatures.SYCAMORE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.2f, 3),
                        ModBlocks.SYCAMORE_SAPLING));
    }

    // Base Required Methods
    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
