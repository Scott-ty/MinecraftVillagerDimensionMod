package net.scott.minecraftvillagerdimensionmod.entity.client;

// Made with Blockbench 4.11.0
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.scott.minecraftvillagerdimensionmod.entity.animation.BlackKoiAnimations;
import net.scott.minecraftvillagerdimensionmod.entity.custom.BlackKoiFishEntity;

public class BlackKoiFishModel<T extends BlackKoiFishEntity> extends SinglePartEntityModel<T> {
	private final ModelPart black_koi_fish;
	private final ModelPart head;

	public BlackKoiFishModel(ModelPart root3) {
		this.black_koi_fish = root3.getChild("black_koi_fish");
		this.head = black_koi_fish.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData black_koi_fish = modelPartData.addChild("black_koi_fish", ModelPartBuilder.create(), ModelTransform.of(0.0F, 23.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData body = black_koi_fish.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-13.0F, -6.0F, -2.0F, 17.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 1.0F, 0.0F));

		ModelPartData head = black_koi_fish.addChild("head", ModelPartBuilder.create().uv(0, 14).cuboid(-1.0F, -3.0F, -1.0F, 4.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -1.5F, 0.0F));

		ModelPartData topfin = black_koi_fish.addChild("topfin", ModelPartBuilder.create().uv(0, 12).cuboid(-6.0F, -2.0F, -0.5F, 9.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 10).cuboid(-5.0F, -1.0F, -0.5F, 10.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, -5.0F, 0.0F));

		ModelPartData tail = black_koi_fish.addChild("tail", ModelPartBuilder.create().uv(12, 17).cuboid(-6.0F, 1.0F, -0.5F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(12, 20).cuboid(-3.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(12, 14).cuboid(-6.0F, -3.0F, -0.5F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-15.0F, -2.0F, 0.0F));

		ModelPartData frontrightfin = black_koi_fish.addChild("frontrightfin", ModelPartBuilder.create().uv(0, 21).cuboid(-3.0F, -2.0F, 0.0F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(24, 14).cuboid(-4.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(8, 21).cuboid(-5.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -1.0F, 2.0F));

		ModelPartData frontleftfin = black_koi_fish.addChild("frontleftfin", ModelPartBuilder.create().uv(22, 10).cuboid(-3.0F, -2.0F, -1.0F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(24, 17).cuboid(-4.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(20, 24).cuboid(-5.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -1.0F, -2.0F));

		ModelPartData backrightfin = black_koi_fish.addChild("backrightfin", ModelPartBuilder.create().uv(22, 22).cuboid(-3.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(14, 23).cuboid(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-10.0F, 0.0F, 2.0F));

		ModelPartData backleftfin = black_koi_fish.addChild("backleftfin", ModelPartBuilder.create().uv(22, 20).cuboid(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(8, 23).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-10.0F, 0.0F, -2.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.animateMovement(BlackKoiAnimations.swim, limbSwing, limbSwingAmount, .5f, .5f);
		this.updateAnimation(entity.blackIdleAnimationState, BlackKoiAnimations.idle, ageInTicks, 2.0f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
		black_koi_fish.render(matrices, vertices, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return black_koi_fish;
	}
}