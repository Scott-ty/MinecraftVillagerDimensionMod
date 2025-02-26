package net.scott.minecraftvillagerdimensionmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.entity.custom.MonarchButterfly;
import net.scott.minecraftvillagerdimensionmod.entity.custom.PillagerBruteBossEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MonarchButterflyEntityRender extends GeoEntityRenderer<MonarchButterfly> {
    public MonarchButterflyEntityRender(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MonarchButterflyEntityModel());
    }

    @Override
    public Identifier getTextureLocation(MonarchButterfly animatable) {
        return animatable.getButterflyTexture();
    }

    @Override
    public void render(MonarchButterfly entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        poseStack.scale(0.2f, 0.2f, 0.2f);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
