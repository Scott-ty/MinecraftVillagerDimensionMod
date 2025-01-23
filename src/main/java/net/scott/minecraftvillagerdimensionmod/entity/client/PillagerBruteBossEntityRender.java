package net.scott.minecraftvillagerdimensionmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.entity.custom.PillagerBruteBossEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PillagerBruteBossEntityRender extends GeoEntityRenderer<PillagerBruteBossEntity> {
    public PillagerBruteBossEntityRender(EntityRendererFactory.Context renderManager) {
        super(renderManager, new PillagerBruteBossEntityModel());
    }

    @Override
    public Identifier getTextureLocation(PillagerBruteBossEntity animatable) {
        return Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "textures/entity/buffpillager.png");
    }

    @Override
    public void render(PillagerBruteBossEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
