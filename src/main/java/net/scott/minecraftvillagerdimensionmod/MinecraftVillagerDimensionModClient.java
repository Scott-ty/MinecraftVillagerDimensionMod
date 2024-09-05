package net.scott.minecraftvillagerdimensionmod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.render.RenderLayer;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.particle.EmeraldFlame;
import net.scott.minecraftvillagerdimensionmod.particle.ModParticleTypes;

public class MinecraftVillagerDimensionModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // These are needed because it would leave the box around the block as black
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EMERALD_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALL_EMERALD_TORCH, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROWAN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROWAN_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROWAN_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JUNIPER_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JUNIPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JUNIPER_TRAPDOOR, RenderLayer.getCutout());

        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.EMERALD_FLAME, EmeraldFlame.Factory::new);
    }
}
