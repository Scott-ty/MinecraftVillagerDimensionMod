package net.scott.minecraftvillagerdimensionmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup MINECRAFT_VILLAGER_DIMENSION_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "ancient_gemstone"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ancient_gemstone"))
                    .icon(() -> new ItemStack(ModItems.ANCIENT_GEMSTONE)).entries(((displayContext, entries) -> {
                            entries.add(ModItems.ANCIENT_GEMSTONE);
                            entries.add(ModItems.ANCIENT_GEMSTONE_DUST);

                            entries.add(ModItems.PILLAGERITE);
                            entries.add(ModItems.PILLAGERITE_INGOT);

                            entries.add(ModItems.MAGICITE);
                            entries.add(ModItems.MAGICITE_DUST);

                            entries.add(ModBlocks.ANCIENT_GEMSTONE_ORE);
                            entries.add(ModBlocks.DEEPSLATE_ANCIENT_GEMSTONE_ORE);
                            entries.add(ModBlocks.ANCIENT_GEMSTONE_BLOCK);

                            entries.add(ModBlocks.PILLAGERITE_ORE);
                            entries.add(ModBlocks.DEEPSLATE_PILLAGERITE_ORE);
                            entries.add(ModBlocks.PILLAGERITE_BLOCK);

                            entries.add(ModBlocks.MAGICITE_ORE);
                            entries.add(ModBlocks.DEEPSLATE_MAGICITE_ORE);
                            entries.add(ModBlocks.MAGICITE_BLOCK);

                            entries.add(ModItems.ANCIENT_GEMSTONE_PICKAXE);
                            entries.add(ModItems.PILLAGERITE_PICKAXE);
                            entries.add(ModItems.MAGICITE_PICKAXE);

                            entries.add(ModItems.ANCIENT_GEMSTONE_AXE);
                            entries.add(ModItems.PILLAGERITE_AXE);
                            entries.add(ModItems.MAGICITE_AXE);

                            entries.add(ModItems.ANCIENT_GEMSTONE_SWORD);
                            entries.add(ModItems.PILLAGERITE_SWORD);
                            entries.add(ModItems.MAGICITE_SWORD);

                            entries.add(ModItems.ANCIENT_GEMSTONE_HOE);
                            entries.add(ModItems.PILLAGERITE_HOE);
                            entries.add(ModItems.MAGICITE_HOE);

                            entries.add(ModItems.ANCIENT_GEMSTONE_SHOVEL);
                            entries.add(ModItems.PILLAGERITE_SHOVEL);
                            entries.add(ModItems.MAGICITE_SHOVEL);

                            entries.add(ModItems.EMERALD_TORCH_ITEM);

                            entries.add(ModBlocks.ROWAN_LOG);
                            entries.add(ModBlocks.ROWAN_WOOD);
                            entries.add(ModBlocks.STRIPPED_ROWAN_LOG);
                            entries.add(ModBlocks.STRIPPED_ROWAN_WOOD);
                            entries.add(ModBlocks.ROWAN_PLANKS);
                            entries.add(ModBlocks.ROWAN_LEAVES);

                            entries.add(ModItems.ROWAN_SIGN);
                            entries.add(ModItems.HANGING_ROWAN_SIGN);

                            entries.add(ModBlocks.ROWAN_SLAB);
                            entries.add(ModBlocks.ROWAN_STAIRS);
                            entries.add(ModBlocks.ROWAN_PRESSURE_PLATE);
                            entries.add(ModBlocks.ROWAN_BUTTON);
                            entries.add(ModBlocks.ROWAN_DOOR);
                            entries.add(ModBlocks.ROWAN_TRAPDOOR);
                            entries.add(ModBlocks.ROWAN_FENCE);
                            entries.add(ModBlocks.ROWAN_FENCE_GATE);


                            entries.add(ModBlocks.JUNIPER_LOG);
                            entries.add(ModBlocks.JUNIPER_WOOD);
                            entries.add(ModBlocks.STRIPPED_JUNIPER_LOG);
                            entries.add(ModBlocks.STRIPPED_JUNIPER_WOOD);
                            entries.add(ModBlocks.JUNIPER_PLANKS);
                            entries.add(ModBlocks.JUNIPER_LEAVES);

                            entries.add(ModItems.JUNIPER_SIGN);
                            entries.add(ModItems.HANGING_JUNIPER_SIGN);

                            entries.add(ModBlocks.JUNIPER_SLAB);
                            entries.add(ModBlocks.JUNIPER_STAIRS);
                            entries.add(ModBlocks.JUNIPER_PRESSURE_PLATE);
                            entries.add(ModBlocks.JUNIPER_BUTTON);
                            entries.add(ModBlocks.JUNIPER_DOOR);
                            entries.add(ModBlocks.JUNIPER_TRAPDOOR);
                            entries.add(ModBlocks.JUNIPER_FENCE);
                            entries.add(ModBlocks.JUNIPER_FENCE_GATE);


                    })).build());

    public static void registerItemGroups(){
        MinecraftVillagerDimensionMod.LOGGER.info("Registering Item Groups for " + MinecraftVillagerDimensionMod.MOD_ID);
    }
}
