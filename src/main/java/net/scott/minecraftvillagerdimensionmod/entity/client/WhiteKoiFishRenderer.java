package net.scott.minecraftvillagerdimensionmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.entity.custom.WhiteKoiFishEntity;

public class WhiteKoiFishRenderer extends MobEntityRenderer<WhiteKoiFishEntity, WhiteKoiFishModel<WhiteKoiFishEntity>> {
    private static final Identifier TEXTURE = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "textures/entity/white_koi_fish.png");

    public WhiteKoiFishRenderer(EntityRendererFactory.Context context) {
        super(context, new WhiteKoiFishModel<>(context.getPart(WhiteKoiModelLayers.WHITE_KOI_FISH)), .2f);
    }

    @Override
    public Identifier getTexture(WhiteKoiFishEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(WhiteKoiFishEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
