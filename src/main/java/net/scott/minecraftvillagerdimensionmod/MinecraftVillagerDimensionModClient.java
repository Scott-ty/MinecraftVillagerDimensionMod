package net.scott.minecraftvillagerdimensionmod;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.entity.ModBoats;
import net.scott.minecraftvillagerdimensionmod.entity.ModEntities;
import net.scott.minecraftvillagerdimensionmod.entity.client.*;
import net.scott.minecraftvillagerdimensionmod.particle.EmeraldFlame;
import net.scott.minecraftvillagerdimensionmod.particle.ModParticleTypes;
import net.scott.minecraftvillagerdimensionmod.world.ModConfiguredFeatures;
import net.scott.minecraftvillagerdimensionmod.world.ModPlacedFeatures;

public class MinecraftVillagerDimensionModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // These are needed because it would leave the box around the block as black
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EMERALD_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALL_EMERALD_TORCH, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROWAN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROWAN_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROWAN_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STANDING_ROWAN_SIGN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALL_ROWAN_SIGN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_ROWAN_SIGN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALL_HANGING_ROWAN_SIGN, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JUNIPER_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JUNIPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JUNIPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STANDING_JUNIPER_SIGN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALL_JUNIPER_SIGN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_JUNIPER_SIGN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALL_HANGING_JUNIPER_SIGN, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SYCAMORE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SYCAMORE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SYCAMORE_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STANDING_SYCAMORE_SIGN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALL_SYCAMORE_SIGN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_SYCAMORE_SIGN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALL_HANGING_SYCAMORE_SIGN, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROWAN_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JUNIPER_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SYCAMORE_SAPLING, RenderLayer.getCutout());

        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.EMERALD_FLAME, EmeraldFlame.Factory::new);

        TerraformBoatClientHelper.registerModelLayers(ModBoats.ROWAN_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.JUNIPER_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.SYCAMORE_BOAT_ID, false);

        EntityRendererRegistry.register(ModEntities.ORANGE_KOI_FISH, OrangeKoiFishRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ORANGE_KOI_FISH, OrangeKoiFishModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.WHITE_KOI_FISH, WhiteKoiFishRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.WHITE_KOI_FISH, WhiteKoiFishModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.BLACK_KOI_FISH, BlackKoiFishRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BLACK_KOI_FISH, BlackKoiFishModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.PILLAGER_BRUTE_BOSS, PillagerBruteBossEntityRender::new);
        EntityRendererRegistry.register(ModEntities.EVIL_VILLAGER_BOSS, EvilVillagerBossEntityRender::new);
        EntityRendererRegistry.register(ModEntities.PILLAGER_WIZARD_BOSS, PillagerWizardBossEntityRender::new);

        EntityRendererRegistry.register(ModEntities.MONARCHBUTTERFLY, MonarchButterflyEntityRender::new);
    }
}
