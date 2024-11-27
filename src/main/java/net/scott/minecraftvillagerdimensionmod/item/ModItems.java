package net.scott.minecraftvillagerdimensionmod.item;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.client.sound.Sound;
import net.minecraft.entity.Bucketable;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Direction;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.entity.ModBoats;
import net.scott.minecraftvillagerdimensionmod.entity.ModEntities;
import net.scott.minecraftvillagerdimensionmod.item.custom.*;

public class ModItems {

    // This is where I add items

    public static final Item EMERALD_TORCH_ITEM = registerItem("emerald_torch_item",
            new VerticallyAttachableBlockItem(ModBlocks.EMERALD_TORCH, ModBlocks.WALL_EMERALD_TORCH, new Item.Settings(), Direction.DOWN));

    public static final Item ANCIENT_GEMSTONE_PICKAXE = registerItem("ancient_gemstone_pickaxe", new PickaxeItem(AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, 1, -2.7F
    ))));
    public static final Item ANCIENT_GEMSTONE_AXE = registerItem("ancient_gemstone_axe", new AxeItem(AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, 5, -2.8F
    ))));
    public static final Item ANCIENT_GEMSTONE_SWORD= registerItem("ancient_gemstone_sword", new SwordItem(AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, 3, -2.4F
    ))));
    public static final Item ANCIENT_GEMSTONE_SHOVEL = registerItem("ancient_gemstone_shovel", new ShovelItem(AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, 1.5F, -2.8F
    ))));
    public static final Item ANCIENT_GEMSTONE_HOE = registerItem("ancient_gemstone_hoe", new HoeItem(AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            AncientGemstoneToolMaterial.ancientGemstoneToolMaterial.ANCIENT_GEMSTONE_DUST, -6, 1
    ))));



    public static final Item  ANCIENT_GEMSTONE_HELMET = registerItem("ancient_gemstone_helmet",
            new CustomArmorItem(ModArmorMaterials.ANCIENT_GEMSTONE_DUST,
                    ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(38))));

    public static final Item  ANCIENT_GEMSTONE_BOOTS = registerItem("ancient_gemstone_boots",
            new ArmorItem(ModArmorMaterials.ANCIENT_GEMSTONE_DUST,
                    ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(38))));

    public static final Item  ANCIENT_GEMSTONE_CHESTPLATE = registerItem("ancient_gemstone_chestplate",
            new ArmorItem(ModArmorMaterials.ANCIENT_GEMSTONE_DUST,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(38))));

    public static final Item  ANCIENT_GEMSTONE_LEGGINGS = registerItem("ancient_gemstone_leggings",
            new ArmorItem(ModArmorMaterials.ANCIENT_GEMSTONE_DUST,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(38))));





    public static final Item PILLAGERITE_PICKAXE = registerItem("pillagerite_pickaxe", new PickaxeItem(PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, 1, -2.7F
    ))));
    public static final Item PILLAGERITE_AXE = registerItem("pillagerite_axe", new AxeItem(PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, 5, -2.8F
    ))));
    public static final Item PILLAGERITE_SWORD = registerItem("pillagerite_sword", new SwordItem(PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, 3, -2.4F
    ))));
    public static final Item PILLAGERITE_SHOVEL = registerItem("pillagerite_shovel", new ShovelItem(PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, 1.3F, -2.8F
    ))));
    public static final Item PILLAGERITE_HOE = registerItem("pillagerite_hoe", new HoeItem(PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            PillageriteToolMaterial.pillageriteToolMaterial.PILLAGERITE_INGOT, -7.2F, 1
    ))));

    public static final Item PILLAGERITE_HELMET = registerItem("pillagerite_helmet",
            new ArmorItem(ModArmorMaterials.PILLAGERITE_INGOT,
                    ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(45))));

    public static final Item PILLAGERITE_BOOTS = registerItem("pillagerite_boots",
            new ArmorItem(ModArmorMaterials.PILLAGERITE_INGOT,
                    ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(45))));

    public static final Item PILLAGERITE_CHESTPLATE = registerItem("pillagerite_chestplate",
            new ArmorItem(ModArmorMaterials.PILLAGERITE_INGOT,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(45))));

    public static final Item PILLAGERITE_LEGGINGS = registerItem("pillagerite_leggings",
            new ArmorItem(ModArmorMaterials.PILLAGERITE_INGOT,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(45))));




    public static final Item MAGICITE_PICKAXE = registerItem("magicite_pickaxe", new PickaxeItem(MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, 1, -2.7F
    ))));
    public static final Item MAGICITE_AXE = registerItem("magicite_axe", new AxeItem(MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, 5, -2.8F
    ))));
    public static final Item MAGICITE_SWORD= registerItem("magicite_sword", new SwordItem(MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, 3, -2.4F
    ))));
    public static final Item MAGICITE_SHOVEL = registerItem("magicite_shovel", new ShovelItem(MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, 1.5F, -2.8F
    ))));
    public static final Item MAGICITE_HOE = registerItem("magicite_hoe", new HoeItem(MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            MagiciteToolMaterial.magiciteToolMaterial.MAGICITE_DUST, -5, 1
    ))));

    public static final Item MAGICITE_HELMET = registerItem("magicite_helmet",
            new ArmorItem(ModArmorMaterials.MAGICITE_DUST,
                    ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(40))));

    public static final Item MAGICITE_BOOTS = registerItem("magicite_boots",
            new ArmorItem(ModArmorMaterials.MAGICITE_DUST,
                    ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(40))));

    public static final Item MAGICITE_CHESTPLATE = registerItem("magicite_chestplate",
            new ArmorItem(ModArmorMaterials.MAGICITE_DUST,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(40))));

    public static final Item MAGICITE_LEGGINGS = registerItem("magicite_leggings",
            new ArmorItem(ModArmorMaterials.MAGICITE_DUST,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40))));



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

    // JUNIPER WOOD
    public static final Item ROWAN_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.ROWAN_BOAT_ID, ModBoats.ROWAN_BOAT_KEY, false);
    public static final Item ROWAN_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.ROWAN_CHEST_BOAT_ID, ModBoats.ROWAN_BOAT_KEY, true);



    // JUNIPER WOOD SIGNS
    public static final Item JUNIPER_SIGN = registerItem("juniper_sign",
            new SignItem(new Item.Settings().maxCount(16), ModBlocks.STANDING_JUNIPER_SIGN, ModBlocks.WALL_JUNIPER_SIGN));
    public static final Item HANGING_JUNIPER_SIGN = registerItem("juniper_hanging_sign",
            new SignItem(new Item.Settings().maxCount(16), ModBlocks.HANGING_JUNIPER_SIGN, ModBlocks.WALL_HANGING_JUNIPER_SIGN));

    // JUNIPER WOOD
    public static final Item JUNIPER_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.JUNIPER_BOAT_ID, ModBoats.JUNIPER_BOAT_KEY, false);
    public static final Item JUNIPER_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.JUNIPER_CHEST_BOAT_ID, ModBoats.JUNIPER_BOAT_KEY, true);



    // SYCAMORE WOOD SIGNS
    public static final Item SYCAMORE_SIGN = registerItem("sycamore_sign",
            new SignItem(new Item.Settings().maxCount(16), ModBlocks.STANDING_SYCAMORE_SIGN, ModBlocks.WALL_SYCAMORE_SIGN));
    public static final Item HANGING_SYCAMORE_SIGN = registerItem("sycamore_hanging_sign",
            new SignItem(new Item.Settings().maxCount(16), ModBlocks.HANGING_SYCAMORE_SIGN, ModBlocks.WALL_HANGING_SYCAMORE_SIGN));

    // SYCAMORE WOOD
    public static final Item SYCAMORE_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.SYCAMORE_BOAT_ID, ModBoats.SYCAMORE_BOAT_KEY, false);
    public static final Item SYCAMORE_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.SYCAMORE_CHEST_BOAT_ID, ModBoats.SYCAMORE_BOAT_KEY, true);

    // SPAWN EGGS
    public static final Item ORANGE_KOI_FISH_SPAWN_EGG = registerItem("orange_koi_fish_spawn_egg",
            new SpawnEggItem(ModEntities.ORANGE_KOI_FISH, 0xffffff, 0xf37800, new Item.Settings()));
    public static final Item WHITE_KOI_FISH_SPAWN_EGG = registerItem("white_koi_fish_spawn_egg",
            new SpawnEggItem(ModEntities.WHITE_KOI_FISH, 0xffffff, 0xFAF9F6, new Item.Settings()));
    public static final Item BLACK_KOI_FISH_SPAWN_EGG = registerItem("black_koi_fish_spawn_egg",
            new SpawnEggItem(ModEntities.BLACK_KOI_FISH, 0xffffff, 0x000000, new Item.Settings()));

    // KOI BUCKET ITEMS
    public static final Item BLACK_KOI_BUCKET = registerItem("black_koi_bucket",
            new EntityBucketItem(ModEntities.BLACK_KOI_FISH, Fluids.WATER, SoundEvents.ENTITY_SALMON_FLOP, new Item.Settings().maxCount(1)));
    public static final Item ORANGE_KOI_BUCKET = registerItem("orange_koi_bucket",
            new EntityBucketItem(ModEntities.ORANGE_KOI_FISH, Fluids.WATER, SoundEvents.ENTITY_SALMON_FLOP, new Item.Settings().maxCount(1)));
    public static final Item WHITE_KOI_BUCKET = registerItem("white_koi_bucket",
            new EntityBucketItem(ModEntities.WHITE_KOI_FISH, Fluids.WATER, SoundEvents.ENTITY_SALMON_FLOP, new Item.Settings().maxCount(1)));

    // BERRIES
    public static final Item JUNIPER_BERRIES = registerItem( "juniper_berries", new Item(new Item.Settings().food(ModFoodComponent.JUNIPER_BERRIES)));
    public static final Item ROWAN_BERRIES = registerItem( "rowan_berries", new Item(new Item.Settings().food(ModFoodComponent.ROWAN_BERRIES)));


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
