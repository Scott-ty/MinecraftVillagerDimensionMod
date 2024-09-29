package net.scott.minecraftvillagerdimensionmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.entity.custom.OrangeKoiFishEntity;

public class OrangeKoiFishRenderer extends MobEntityRenderer<OrangeKoiFishEntity, OrangeKoiFishModel<OrangeKoiFishEntity>> {
    private static final Identifier TEXTURE = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "textures/entity/orange_koi_fish.png");

    public OrangeKoiFishRenderer(EntityRendererFactory.Context context) {
        super(context, new OrangeKoiFishModel<>(context.getPart(ModModelLayers.ORANGE_KOI_FISH)), .2f);
    }

    @Override
    public Identifier getTexture(OrangeKoiFishEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(OrangeKoiFishEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
