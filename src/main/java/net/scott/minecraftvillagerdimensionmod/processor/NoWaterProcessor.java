package net.scott.minecraftvillagerdimensionmod.processor;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import org.jetbrains.annotations.Nullable;

public class NoWaterProcessor extends StructureProcessor {
    public static final MapCodec<NoWaterProcessor> CODEC = MapCodec.unit(NoWaterProcessor::new);

    @Override
    @Nullable
    public StructureTemplate.StructureBlockInfo process(
            WorldView world, BlockPos pos, BlockPos pivot,
            StructureTemplate.StructureBlockInfo structureBlockInfo,
            StructureTemplate.StructureBlockInfo structureBlockInfo2,
            StructurePlacementData structurePlacementData
    ) {
        BlockPos blockPos = structureBlockInfo2.pos();
        BlockState blockState = world.getBlockState(blockPos);

        // Check if the block is water
        if (blockState.isOf(Blocks.WATER)) {
            MinecraftVillagerDimensionMod.LOGGER.info("Water detected at {} - removing structure blocks above", blockPos);

            // Remove this block
            return null;
        }

        // Check if there is water below this block
        BlockPos.Mutable searchPos = blockPos.mutableCopy();
        while (searchPos.getY() > world.getBottomY()) {
            searchPos.move(0, -1, 0);
            BlockState belowState = world.getBlockState(searchPos);

            if (belowState.isOf(Blocks.WATER)) {
                MinecraftVillagerDimensionMod.LOGGER.info("Block {} is above water - removing", blockPos);
                return null; // Remove this block because it is above water
            }
        }

        // No water found below, keep the block
        return structureBlockInfo2;
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return MinecraftVillagerDimensionMod.NO_WATER_PROCESSOR;
    }
}