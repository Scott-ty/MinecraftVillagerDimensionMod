package net.scott.minecraftvillagerdimensionmod;

import com.terraformersmc.terraform.sign.api.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
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

        // ROWAN WOOD SIGNS
        //SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.ROWAN_SIGN_TEXTURE));
        //SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.ROWAN_HANGING_SIGN_TEXTURE));

        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.EMERALD_FLAME, EmeraldFlame.Factory::new);
    }
}
