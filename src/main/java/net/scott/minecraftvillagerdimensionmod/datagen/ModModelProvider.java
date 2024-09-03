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

        //************************************* ROWAN WOOD *******************************************************************//
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

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        // ROWAN WOOD SIGNS
        itemModelGenerator.register(ModItems.HANGING_ROWAN_SIGN, Models.GENERATED);

    }
}
