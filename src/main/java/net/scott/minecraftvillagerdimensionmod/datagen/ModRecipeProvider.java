package net.scott.minecraftvillagerdimensionmod.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;

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
        //*******************************************************************************************************************//
    }
}

