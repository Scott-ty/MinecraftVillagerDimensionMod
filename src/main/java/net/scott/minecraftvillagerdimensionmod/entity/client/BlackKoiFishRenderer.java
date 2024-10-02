package net.scott.minecraftvillagerdimensionmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.entity.custom.BlackKoiFishEntity;

public class BlackKoiFishRenderer extends MobEntityRenderer<BlackKoiFishEntity, BlackKoiFishModel<BlackKoiFishEntity>> {
    private static final Identifier TEXTURE = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "textures/entity/black_koi_fish.png");

    public BlackKoiFishRenderer(EntityRendererFactory.Context context) {
        super(context, new BlackKoiFishModel<>(context.getPart(ModModelLayers.BLACK_KOI_FISH)), .2f);
    }

    @Override
    public Identifier getTexture(BlackKoiFishEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(BlackKoiFishEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
