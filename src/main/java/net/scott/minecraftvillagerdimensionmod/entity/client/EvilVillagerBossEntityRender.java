package net.scott.minecraftvillagerdimensionmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.entity.custom.EvilVillagerBossEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EvilVillagerBossEntityRender extends GeoEntityRenderer<EvilVillagerBossEntity> {
    public EvilVillagerBossEntityRender(EntityRendererFactory.Context renderManager) {
        super(renderManager, new EvilVillagerBossEntityModel());
    }

    @Override
    public Identifier getTextureLocation(EvilVillagerBossEntity animatable) {
        return Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "textures/entity/evil_villager.png");
    }

    @Override
    public void render(EvilVillagerBossEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
