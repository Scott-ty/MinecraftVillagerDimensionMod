package net.scott.minecraftvillagerdimensionmod.world.structure;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Blocks;
import net.minecraft.structure.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.noise.NoiseConfig;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;
import net.scott.minecraftvillagerdimensionmod.world.ModStructures;

import java.util.Optional;

public class LargeKoiPondStructure extends Structure {
    public static final MapCodec<LargeKoiPondStructure> CODEC = createCodec(LargeKoiPondStructure::new);

    public LargeKoiPondStructure(Structure.Config config) {
        super(config);
    }

    @Override
    protected Optional<StructurePosition> getStructurePosition(Context context) {
        // Get the starting position of the chunk
        BlockPos chunkPos = context.chunkPos().getStartPos();
        NoiseConfig noiseConfig = context.noiseConfig();

        // Get the top solid block's Y coordinate
        int topY = context.chunkGenerator().getHeight(
                chunkPos.getX(), chunkPos.getZ(), Heightmap.Type.WORLD_SURFACE_WG,
                context.world(), noiseConfig
        );

        // Get the block below the highest terrain point
        BlockPos belowTop = new BlockPos(chunkPos.getX(), topY - 1, chunkPos.getZ());

        // Check if the block below is water
        if (context.chunkGenerator().getColumnSample(belowTop.getX(), belowTop.getZ(), context.world(), noiseConfig)
                .getState(belowTop.getY()).isOf(Blocks.WATER)) {
            // Prevent structure generation if water is below
            return Optional.empty();
        }

        // If the location is valid, return the position where the structure should generate
        //return Optional.of(new StructurePosition(belowTop, (structurePiecesCollector) ->
        // generatePieces(structurePiecesCollector, context, belowTop)
        //));
        return Optional.empty();
    }

//    private void generatePieces(StructurePiecesCollector collector, Context context, BlockPos pos) {
//        StructureTemplateManager templateManager = context.structureTemplateManager();
//        Identifier structureId = Identifier.of("minecraftvillagerdimensionmod", "large_koi_pond");
//
//        Optional<StructureTemplate> templateOptional = templateManager.getTemplate(structureId);
//        if (templateOptional.isEmpty()) {
//            System.err.println("Failed to load structure: " + structureId);
//            return;
//        }
//
//        StructureTemplate template = templateOptional.get();
//        StructureTemplate.placementData placementData = new StructureTemplate.PlacementData();
//
//        // Add the structure piece to the collector
//        collector.addPiece(new SimpleStructurePiece(context.structureTemplateManager(), structureId, pos, placementData));
//    }
//    private void generatePieces(StructurePiecesGenerator structurePiecesGenerator, Context context) {
//        // Implement the logic to generate the structure pieces here
//        // For example, add different parts of the koi pond structure
//    }

    @Override
    public StructureType<?> getType() {
        return ModStructures.LARGE_KOI_POND_TYPE;
    }
}