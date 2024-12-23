package net.scott.minecraftvillagerdimensionmod.item.custom;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.stat.Stat;

public class ModFoodComponent {
    public static final FoodComponent JUNIPER_BERRIES = new FoodComponent.Builder().snack().nutrition(1).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 90), 0.1f).build();
    public static final FoodComponent ROWAN_BERRIES = new FoodComponent.Builder().snack().nutrition(1).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), 0.1f).build();
    public static final FoodComponent JUNIPER_BREAD = new FoodComponent.Builder().snack().nutrition(5).saturationModifier(3.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 90), 0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), 0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 0.3f).build();
}
