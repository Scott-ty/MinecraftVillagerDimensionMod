package net.scott.minecraftvillagerdimensionmod.entity.client;

import com.llamalad7.mixinextras.lib.apache.commons.ObjectUtils;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.entity.custom.PillagerBruteBossEntity;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class PillagerBruteBossEntityModel  extends GeoModel<PillagerBruteBossEntity> {

    @Override
    public Identifier getModelResource(PillagerBruteBossEntity animatable) {
        return Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "geo/buffpillager.geo.json");
    }

    @Override
    public Identifier getTextureResource(PillagerBruteBossEntity animatable) {
        return Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "textures/entity/buffpillager.png");

    }

    @Override
    public Identifier getAnimationResource(PillagerBruteBossEntity animatable) {
        return Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "animations/buffpillager.animation.json");

    }

//    @Override
//    public void setCustomAnimations(PillagerBruteBossEntity animatable, long instanceId, AnimationState<PillagerBruteBossEntity> animationState){
//        GeoBone head = getAnimationProcessor().getBone("head");
//
//        		if (head != null) {
//			EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
//			head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
//			head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
//		}
//   }
}
