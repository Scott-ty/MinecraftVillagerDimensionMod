package net.scott.minecraftvillagerdimensionmod.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;
import net.scott.minecraftvillagerdimensionmod.item.custom.ModArmorMaterials;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);

    }
    @Override
    public void generate(RecipeExporter exporter) {

        //************************************* ROWAN WOOD ****************************************************************//
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROWAN_SLAB, ModBlocks.ROWAN_PLANKS);
        createStairsRecipe(ModBlocks.ROWAN_STAIRS, Ingredient.ofItems(ModBlocks.ROWAN_PLANKS))
                .criterion("a_dark_wood", InventoryChangedCriterion.Conditions.items(ModBlocks.ROWAN_LOG)
                        ).offerTo(exporter);
        createFenceGateRecipe(ModBlocks.ROWAN_FENCE_GATE, Ingredient.ofItems(ModBlocks.ROWAN_PLANKS))
                .criterion("a_dark_wood", InventoryChangedCriterion.Conditions.items(ModBlocks.ROWAN_LOG)
                ).offerTo(exporter);
        createFenceRecipe(ModBlocks.ROWAN_FENCE, Ingredient.ofItems(ModBlocks.ROWAN_PLANKS))
                .criterion("a_dark_wood", InventoryChangedCriterion.Conditions.items(ModBlocks.ROWAN_LOG)
                ).offerTo(exporter);
        offerPressurePlateRecipe(exporter, ModBlocks.ROWAN_PRESSURE_PLATE, ModBlocks.ROWAN_PLANKS);

        createDoorRecipe(ModBlocks.ROWAN_DOOR, Ingredient.ofItems(ModBlocks.ROWAN_PLANKS))
                .criterion("a_dark_wood", InventoryChangedCriterion.Conditions.items(ModBlocks.ROWAN_LOG)
                ).offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.ROWAN_TRAPDOOR, Ingredient.ofItems(ModBlocks.ROWAN_PLANKS))
                .criterion("a_dark_wood", InventoryChangedCriterion.Conditions.items(ModBlocks.ROWAN_LOG)
                ).offerTo(exporter);
        offerHangingSignRecipe(exporter, ModItems.HANGING_ROWAN_SIGN, ModBlocks.ROWAN_PLANKS);
        createSignRecipe(ModItems.ROWAN_SIGN, Ingredient.ofItems(ModBlocks.ROWAN_PLANKS))
                .criterion("a_dark_wood", InventoryChangedCriterion.Conditions.items(ModBlocks.ROWAN_LOG)
                ).offerTo(exporter);

        offerBoatRecipe(exporter, ModItems.ROWAN_BOAT, ModBlocks.ROWAN_PLANKS);
        offerChestBoatRecipe(exporter, ModItems.ROWAN_CHEST_BOAT, ModItems.JUNIPER_BOAT);
        //*******************************************************************************************************************//

        //************************************* JUNIPER WOOD ****************************************************************//
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JUNIPER_SLAB, ModBlocks.JUNIPER_PLANKS);
        createStairsRecipe(ModBlocks.JUNIPER_STAIRS, Ingredient.ofItems(ModBlocks.JUNIPER_PLANKS))
                .criterion("feeling_grey", InventoryChangedCriterion.Conditions.items(ModBlocks.JUNIPER_LOG)
                ).offerTo(exporter);
        createFenceGateRecipe(ModBlocks.JUNIPER_FENCE_GATE, Ingredient.ofItems(ModBlocks.JUNIPER_PLANKS))
                .criterion("feeling_grey", InventoryChangedCriterion.Conditions.items(ModBlocks.JUNIPER_LOG)
                ).offerTo(exporter);
        createFenceRecipe(ModBlocks.JUNIPER_FENCE, Ingredient.ofItems(ModBlocks.JUNIPER_PLANKS))
                .criterion("feeling_grey", InventoryChangedCriterion.Conditions.items(ModBlocks.JUNIPER_LOG)
                ).offerTo(exporter);
        offerPressurePlateRecipe(exporter, ModBlocks.JUNIPER_PRESSURE_PLATE, ModBlocks.JUNIPER_PLANKS);

        createDoorRecipe(ModBlocks.JUNIPER_DOOR, Ingredient.ofItems(ModBlocks.JUNIPER_PLANKS))
                .criterion("feeling_grey", InventoryChangedCriterion.Conditions.items(ModBlocks.JUNIPER_LOG)
                ).offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.JUNIPER_TRAPDOOR, Ingredient.ofItems(ModBlocks.JUNIPER_PLANKS))
                .criterion("feeling_grey", InventoryChangedCriterion.Conditions.items(ModBlocks.JUNIPER_LOG)
                ).offerTo(exporter);
        offerHangingSignRecipe(exporter, ModItems.HANGING_JUNIPER_SIGN, ModBlocks.JUNIPER_PLANKS);
        createSignRecipe(ModItems.JUNIPER_SIGN, Ingredient.ofItems(ModBlocks.JUNIPER_PLANKS))
                .criterion("feeling_grey", InventoryChangedCriterion.Conditions.items(ModBlocks.JUNIPER_LOG)
                ).offerTo(exporter);
        offerBoatRecipe(exporter, ModItems.JUNIPER_BOAT, ModBlocks.JUNIPER_PLANKS);
        offerChestBoatRecipe(exporter, ModItems.JUNIPER_CHEST_BOAT, ModItems.JUNIPER_BOAT);
        //*******************************************************************************************************************//

        //************************************* SYCAMORE WOOD ****************************************************************//
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYCAMORE_SLAB, ModBlocks.SYCAMORE_PLANKS);
        createStairsRecipe(ModBlocks.SYCAMORE_STAIRS, Ingredient.ofItems(ModBlocks.SYCAMORE_PLANKS))
                .criterion("youre_syc", InventoryChangedCriterion.Conditions.items(ModBlocks.SYCAMORE_LOG)
                ).offerTo(exporter);
        createFenceGateRecipe(ModBlocks.SYCAMORE_FENCE_GATE, Ingredient.ofItems(ModBlocks.SYCAMORE_PLANKS))
                .criterion("youre_syc", InventoryChangedCriterion.Conditions.items(ModBlocks.SYCAMORE_LOG)
                ).offerTo(exporter);
        createFenceRecipe(ModBlocks.SYCAMORE_FENCE, Ingredient.ofItems(ModBlocks.SYCAMORE_PLANKS))
                .criterion("youre_syc", InventoryChangedCriterion.Conditions.items(ModBlocks.SYCAMORE_LOG)
                ).offerTo(exporter);
        offerPressurePlateRecipe(exporter, ModBlocks.SYCAMORE_PRESSURE_PLATE, ModBlocks.SYCAMORE_PLANKS);

        createDoorRecipe(ModBlocks.SYCAMORE_DOOR, Ingredient.ofItems(ModBlocks.SYCAMORE_PLANKS))
                .criterion("youre_syc", InventoryChangedCriterion.Conditions.items(ModBlocks.SYCAMORE_LOG)
                ).offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.SYCAMORE_TRAPDOOR, Ingredient.ofItems(ModBlocks.SYCAMORE_PLANKS))
                .criterion("youre_syc", InventoryChangedCriterion.Conditions.items(ModBlocks.SYCAMORE_LOG)
                ).offerTo(exporter);
        offerHangingSignRecipe(exporter, ModItems.HANGING_SYCAMORE_SIGN, ModBlocks.SYCAMORE_PLANKS);
        createSignRecipe(ModItems.SYCAMORE_SIGN, Ingredient.ofItems(ModBlocks.SYCAMORE_PLANKS))
                .criterion("youre_syc", InventoryChangedCriterion.Conditions.items(ModBlocks.SYCAMORE_LOG)
                ).offerTo(exporter);
        offerBoatRecipe(exporter, ModItems.SYCAMORE_BOAT, ModBlocks.SYCAMORE_PLANKS);
        offerChestBoatRecipe(exporter, ModItems.SYCAMORE_CHEST_BOAT, ModItems.SYCAMORE_BOAT);
        //*******************************************************************************************************************//
        
        // ANCIENT GEMSTONE
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ANCIENT_GEMSTONE_HELMET)
                .input('E', ModItems.ANCIENT_GEMSTONE_DUST)
                .pattern("EEE")
                .pattern("E E")
                .criterion(hasItem(ModItems.ANCIENT_GEMSTONE_DUST), conditionsFromItem(ModItems.ANCIENT_GEMSTONE_DUST))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ANCIENT_GEMSTONE_CHESTPLATE)
                .input('E', ModItems.ANCIENT_GEMSTONE_DUST)
                .pattern("E E")
                .pattern("EEE")
                .pattern("EEE")
                .criterion(hasItem(ModItems.ANCIENT_GEMSTONE_DUST), conditionsFromItem(ModItems.ANCIENT_GEMSTONE_DUST))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ANCIENT_GEMSTONE_LEGGINGS)
                .input('E', ModItems.ANCIENT_GEMSTONE_DUST)
                .pattern("EEE")
                .pattern("E E")
                .pattern("E E")
                .criterion(hasItem(ModItems.ANCIENT_GEMSTONE_DUST), conditionsFromItem(ModItems.ANCIENT_GEMSTONE_DUST))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ANCIENT_GEMSTONE_BOOTS)
                .input('E', ModItems.ANCIENT_GEMSTONE_DUST)
                .pattern("E E")
                .pattern("E E")
                .criterion(hasItem(ModItems.ANCIENT_GEMSTONE_DUST), conditionsFromItem(ModItems.ANCIENT_GEMSTONE_DUST))
                .offerTo(exporter);

        // PILLAGERITE
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PILLAGERITE_HELMET)
                .input('E', ModItems.PILLAGERITE_INGOT)
                .pattern("EEE")
                .pattern("E E")
                .criterion(hasItem(ModItems.PILLAGERITE_INGOT), conditionsFromItem(ModItems.PILLAGERITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PILLAGERITE_CHESTPLATE)
                .input('E', ModItems.PILLAGERITE_INGOT)
                .pattern("E E")
                .pattern("EEE")
                .pattern("EEE")
                .criterion(hasItem(ModItems.PILLAGERITE_INGOT), conditionsFromItem(ModItems.PILLAGERITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PILLAGERITE_LEGGINGS)
                .input('E', ModItems.PILLAGERITE_INGOT)
                .pattern("EEE")
                .pattern("E E")
                .pattern("E E")
                .criterion(hasItem(ModItems.PILLAGERITE_INGOT), conditionsFromItem(ModItems.PILLAGERITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PILLAGERITE_BOOTS)
                .input('E', ModItems.PILLAGERITE_INGOT)
                .pattern("E E")
                .pattern("E E")
                .criterion(hasItem(ModItems.PILLAGERITE_INGOT), conditionsFromItem(ModItems.PILLAGERITE_INGOT))
                .offerTo(exporter);

        // MAGICITE
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MAGICITE_HELMET)
                .input('E', ModItems.MAGICITE_DUST)
                .pattern("EEE")
                .pattern("E E")
                .criterion(hasItem(ModItems.MAGICITE_DUST), conditionsFromItem(ModItems.MAGICITE_DUST))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MAGICITE_CHESTPLATE)
                .input('E', ModItems.MAGICITE_DUST)
                .pattern("E E")
                .pattern("EEE")
                .pattern("EEE")
                .criterion(hasItem(ModItems.MAGICITE_DUST), conditionsFromItem(ModItems.MAGICITE_DUST))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MAGICITE_LEGGINGS)
                .input('E', ModItems.MAGICITE_DUST)
                .pattern("EEE")
                .pattern("E E")
                .pattern("E E")
                .criterion(hasItem(ModItems.MAGICITE_DUST), conditionsFromItem(ModItems.MAGICITE_DUST))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MAGICITE_BOOTS)
                .input('E', ModItems.MAGICITE_DUST)
                .pattern("E E")
                .pattern("E E")
                .criterion(hasItem(ModItems.MAGICITE_DUST), conditionsFromItem(ModItems.MAGICITE_DUST))
                .offerTo(exporter);
    }
}

