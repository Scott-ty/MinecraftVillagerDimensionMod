package net.scott.minecraftvillagerdimensionmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg){

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ROWAN_LOG)
                .add(ModBlocks.STRIPPED_ROWAN_LOG)
                .add(ModBlocks.ROWAN_WOOD)
                .add(ModBlocks.STRIPPED_ROWAN_WOOD);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.ROWAN_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ROWAN_FENCE_GATE);
        //*******************************************************************************************************************//


        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.JUNIPER_LOG)
                .add(ModBlocks.STRIPPED_JUNIPER_LOG)
                .add(ModBlocks.JUNIPER_WOOD)
                .add(ModBlocks.STRIPPED_JUNIPER_WOOD);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.JUNIPER_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.JUNIPER_FENCE_GATE);
        //*******************************************************************************************************************//



        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.SYCAMORE_LOG)
                .add(ModBlocks.STRIPPED_SYCAMORE_LOG)
                .add(ModBlocks.SYCAMORE_WOOD)
                .add(ModBlocks.STRIPPED_SYCAMORE_WOOD);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.SYCAMORE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.SYCAMORE_FENCE_GATE);
        //*******************************************************************************************************************//
    }
}
