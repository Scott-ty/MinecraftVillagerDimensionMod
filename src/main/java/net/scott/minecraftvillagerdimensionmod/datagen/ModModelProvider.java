package net.scott.minecraftvillagerdimensionmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        //************************************* ROWAN WOOD ****************************************************************//
        blockStateModelGenerator.registerLog(ModBlocks.ROWAN_LOG).log(ModBlocks.ROWAN_LOG).wood(ModBlocks.ROWAN_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_ROWAN_LOG).log(ModBlocks.STRIPPED_ROWAN_LOG).wood(ModBlocks.STRIPPED_ROWAN_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROWAN_LEAVES);

        BlockStateModelGenerator.BlockTexturePool rowan_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROWAN_PLANKS);
        rowan_pool.family(ModBlocks.ROWAN_FAMILY);
        rowan_pool.stairs(ModBlocks.ROWAN_STAIRS);
        rowan_pool.button(ModBlocks.ROWAN_BUTTON);
        rowan_pool.slab(ModBlocks.ROWAN_SLAB);
        rowan_pool.pressurePlate(ModBlocks.ROWAN_PRESSURE_PLATE);
        rowan_pool.fence(ModBlocks.ROWAN_FENCE);
        rowan_pool.fenceGate(ModBlocks.ROWAN_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.ROWAN_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ROWAN_TRAPDOOR);

        //*******************************************************************************************************************//
        //************************************* JUNIPER WOOD ****************************************************************//
        blockStateModelGenerator.registerLog(ModBlocks.JUNIPER_LOG).log(ModBlocks.JUNIPER_LOG).wood(ModBlocks.JUNIPER_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_JUNIPER_LOG).log(ModBlocks.STRIPPED_JUNIPER_LOG).wood(ModBlocks.STRIPPED_JUNIPER_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.JUNIPER_LEAVES);

        BlockStateModelGenerator.BlockTexturePool juniper_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JUNIPER_PLANKS);
        juniper_pool.family(ModBlocks.JUNIPER_FAMILY);
        juniper_pool.stairs(ModBlocks.JUNIPER_STAIRS);
        juniper_pool.button(ModBlocks.JUNIPER_BUTTON);
        juniper_pool.slab(ModBlocks.JUNIPER_SLAB);
        juniper_pool.pressurePlate(ModBlocks.JUNIPER_PRESSURE_PLATE);
        juniper_pool.fence(ModBlocks.JUNIPER_FENCE);
        juniper_pool.fenceGate(ModBlocks.JUNIPER_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.JUNIPER_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.JUNIPER_TRAPDOOR);
        //*******************************************************************************************************************//
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        // ROWAN WOOD SIGNS
        itemModelGenerator.register(ModItems.HANGING_ROWAN_SIGN, Models.GENERATED);

        // JUNIPER WOOD SIGNS
        itemModelGenerator.register(ModItems.HANGING_JUNIPER_SIGN, Models.GENERATED);

    }
}
