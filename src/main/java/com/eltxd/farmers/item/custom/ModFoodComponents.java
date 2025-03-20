package com.eltxd.farmers.item.custom;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {

    public static final FoodComponent BERRY_PIE = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 2), 1f).build();

}
