package net.scott.minecraftvillagerdimensionmod.item.custom;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponent {
    public static final FoodComponent JUNIPER_BERRIES = new FoodComponent.Builder().snack().nutrition(1).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1), 0.1f).build();
    public static final FoodComponent ROWAN_BERRIES = new FoodComponent.Builder().snack().nutrition(1).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), 0.1f).build();
}
