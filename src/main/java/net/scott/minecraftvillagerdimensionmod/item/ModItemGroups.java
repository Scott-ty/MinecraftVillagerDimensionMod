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
                            entries.add(ModBlocks.ANCIENT_GEMSTONE_ORE);
                            entries.add(ModItems.PILLAGERITE);
                            entries.add(ModItems.PILLAGERITE_INGOT);
                            entries.add(ModBlocks.PILLAGERITE_ORE);
                            entries.add(ModItems.MAGICITE);
                            entries.add(ModItems.MAGICITE_DUST);



                    })).build());

    public static void registerItemGroups(){
        MinecraftVillagerDimensionMod.LOGGER.info("Registering Item Groups for " + MinecraftVillagerDimensionMod.MOD_ID);
    }
}
