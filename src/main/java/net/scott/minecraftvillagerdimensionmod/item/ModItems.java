package net.scott.minecraftvillagerdimensionmod.item;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.Direction;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.item.custom.AncientGemstoneToolMaterial;
import net.scott.minecraftvillagerdimensionmod.item.custom.MagiciteToolMaterial;
import net.scott.minecraftvillagerdimensionmod.item.custom.PillageriteToolMaterial;

public class ModItems {

    // This is where I add items

    public static final Item EMERALD_TORCH_ITEM = registerItem("emerald_torch_item",
            new VerticallyAttachableBlockItem(ModBlocks.EMERALD_TORCH, ModBlocks.WALL_EMERALD_TORCH, new Item.Settings(), Direction.DOWN));

    public static final Item ANCIENT_GEMSTONE_PICKAXE = registerItem("ancient_gemstone_pickaxe", new PickaxeItem(AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, 3, -2.4F
    ))));
    public static final Item ANCIENT_GEMSTONE_AXE = registerItem("ancient_gemstone_axe", new AxeItem(AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, 3, -2.4F
    ))));
    public static final Item ANCIENT_GEMSTONE_SWORD= registerItem("ancient_gemstone_sword", new SwordItem(AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, 3, -2.4F
    ))));
    public static final Item ANCIENT_GEMSTONE_SHOVEL = registerItem("ancient_gemstone_shovel", new ShovelItem(AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, 3, -2.4F
    ))));
    public static final Item ANCIENT_GEMSTONE_HOE = registerItem("ancient_gemstone_hoe", new HoeItem(AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, 3, -2.4F
    ))));

    public static final Item PILLAGERITE_PICKAXE = registerItem("pillagerite_pickaxe", new PickaxeItem(PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, 3, -2.4F
    ))));
    public static final Item PILLAGERITE_AXE = registerItem("pillagerite_axe", new AxeItem(PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, 3, -2.4F
    ))));
    public static final Item PILLAGERITE_SWORD = registerItem("pillagerite_sword", new SwordItem(PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, 3, -2.4F
    ))));
    public static final Item PILLAGERITE_SHOVEL = registerItem("pillagerite_shovel", new ShovelItem(PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, 3, -2.4F
    ))));
    public static final Item PILLAGERITE_HOE = registerItem("pillagerite_hoe", new HoeItem(PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, 3, -2.4F
    ))));

    public static final Item MAGICITE_PICKAXE = registerItem("magicite_pickaxe", new PickaxeItem(MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, 3, -2.4F
    ))));
    public static final Item MAGICITE_AXE = registerItem("magicite_axe", new AxeItem(MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, 3, -2.4F
    ))));
    public static final Item MAGICITE_SWORD= registerItem("magicite_sword", new SwordItem(MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, 3, -2.4F
    ))));
    public static final Item MAGICITE_SHOVEL = registerItem("magicite_shovel", new ShovelItem(MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, 3, -2.4F
    ))));
    public static final Item MAGICITE_HOE = registerItem("magicite_hoe", new HoeItem(MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, 3, -2.4F
    ))));

    public static final Item ANCIENT_GEMSTONE = registerItem("ancient_gemstone", new Item(new Item.Settings()));
    public static final Item ANCIENT_GEMSTONE_DUST = registerItem("ancient_gemstone_dust", new Item(new Item.Settings()));
    public static final Item PILLAGERITE = registerItem("pillagerite", new Item(new Item.Settings()));
    public static final Item PILLAGERITE_INGOT = registerItem("pillagerite_ingot", new Item(new Item.Settings()));
    public static final Item MAGICITE = registerItem("magicite", new Item(new Item.Settings()));
    public static final Item MAGICITE_DUST = registerItem("magicite_dust", new Item(new Item.Settings()));


    // ROWAN WOOD SIGNS
    public static final Item ROWAN_SIGN = registerItem("rowan_sign",
            new SignItem(new Item.Settings().maxCount(16), ModBlocks.STANDING_ROWAN_SIGN, ModBlocks.WALL_ROWAN_SIGN));
    public static final Item HANGING_ROWAN_SIGN = registerItem("rowan_hanging_sign",
            new SignItem(new Item.Settings().maxCount(16), ModBlocks.HANGING_ROWAN_SIGN, ModBlocks.WALL_HANGING_ROWAN_SIGN));


    // Once an item has been made, you have to add it to a group
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        MinecraftVillagerDimensionMod.LOGGER.info("Registering Mod Items for " + MinecraftVillagerDimensionMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
