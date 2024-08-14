package net.scott.minecraftvillagerdimensionmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.minecraft.util.Identifier;

public class ModItems {

    // This is where I add items
    public static final Item ANCIENT_GEMSTONE = registerItem("ancient_gemstone", new Item(new Item.Settings()));
    public static final Item ANCIENT_GEMSTONE_DUST = registerItem("ancient_gemstone_dust", new Item(new Item.Settings()));
    // Once an item has been made, you have to add it to a group
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
        entries.add(ANCIENT_GEMSTONE);
        entries.add(ANCIENT_GEMSTONE_DUST);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        MinecraftVillagerDimensionMod.LOGGER.info("Registering Mod Items for " + MinecraftVillagerDimensionMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
