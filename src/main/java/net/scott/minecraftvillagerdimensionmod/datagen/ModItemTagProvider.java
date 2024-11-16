package net.scott.minecraftvillagerdimensionmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemKeys;
import net.minecraft.item.Items;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
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
        //************************************* ANCIENT GEMSTONE ************************************************************//
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.ANCIENT_GEMSTONE_SWORD);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.ANCIENT_GEMSTONE_AXE );
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.ANCIENT_GEMSTONE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.ANCIENT_GEMSTONE_HOE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.ANCIENT_GEMSTONE_PICKAXE);


        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.ANCIENT_GEMSTONE_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.ANCIENT_GEMSTONE_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.ANCIENT_GEMSTONE_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.ANCIENT_GEMSTONE_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ANCIENT_GEMSTONE_HELMET, ModItems.ANCIENT_GEMSTONE_CHESTPLATE, ModItems.ANCIENT_GEMSTONE_LEGGINGS, ModItems.ANCIENT_GEMSTONE_BOOTS);
        //*******************************************************************************************************************//

        //************************************* PILLAGERITE ************************************************************//
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.PILLAGERITE_SWORD);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.PILLAGERITE_AXE );
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.PILLAGERITE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.PILLAGERITE_HOE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.PILLAGERITE_PICKAXE);


        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.PILLAGERITE_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.PILLAGERITE_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.PILLAGERITE_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.PILLAGERITE_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PILLAGERITE_HELMET, ModItems.PILLAGERITE_CHESTPLATE, ModItems.PILLAGERITE_LEGGINGS, ModItems.PILLAGERITE_BOOTS);
        //*******************************************************************************************************************//

        //************************************* MAGICITE ********************************************************************//
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.MAGICITE_SWORD);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.MAGICITE_AXE );
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.MAGICITE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.MAGICITE_HOE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.MAGICITE_PICKAXE);


        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.MAGICITE_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.MAGICITE_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.MAGICITE_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.MAGICITE_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.MAGICITE_HELMET, ModItems.MAGICITE_CHESTPLATE, ModItems.MAGICITE_LEGGINGS, ModItems.MAGICITE_BOOTS);
        //*******************************************************************************************************************//
    }
}