package net.scott.minecraftvillagerdimensionmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        //************************************* ROWAN WOOD ****************************************************************//
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.ROWAN_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.ROWAN_LOG.asItem())
                .add(ModBlocks.STRIPPED_ROWAN_LOG.asItem())
                .add(ModBlocks.ROWAN_WOOD.asItem())
                .add(ModBlocks.STRIPPED_ROWAN_WOOD.asItem());
        //*******************************************************************************************************************//

        //************************************* JUNIPER WOOD ****************************************************************//
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.JUNIPER_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.JUNIPER_LOG.asItem())
                .add(ModBlocks.STRIPPED_JUNIPER_LOG.asItem())
                .add(ModBlocks.JUNIPER_WOOD.asItem())
                .add(ModBlocks.STRIPPED_JUNIPER_WOOD.asItem());
        //*******************************************************************************************************************//

        //************************************* SYCAMORE WOOD ****************************************************************//
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.SYCAMORE_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.SYCAMORE_LOG.asItem())
                .add(ModBlocks.STRIPPED_SYCAMORE_LOG.asItem())
                .add(ModBlocks.SYCAMORE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_SYCAMORE_WOOD.asItem());
        //*******************************************************************************************************************//

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ANCIENT_GEMSTONE_HELMET, ModItems.ANCIENT_GEMSTONE_CHESTPLATE, ModItems.ANCIENT_GEMSTONE_LEGGING, ModItems.ANCIENT_GEMSTONE_BOOTS);
    }
}