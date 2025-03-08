package net.scott.minecraftvillagerdimensionmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.entity.custom.PillagerBruteBossEntity;
import net.scott.minecraftvillagerdimensionmod.entity.custom.PillagerWizardBossEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PillagerWizardBossEntityRender extends GeoEntityRenderer<PillagerWizardBossEntity> {
    public PillagerWizardBossEntityRender(EntityRendererFactory.Context renderManager) {
        super(renderManager, new PillagerWizardBossEntityModel());
    }

    @Override
    public Identifier getTextureLocation(PillagerWizardBossEntity animatable) {
        return Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "textures/entity/wizard_pillager.png");
    }

    @Override
    public void render(PillagerWizardBossEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
