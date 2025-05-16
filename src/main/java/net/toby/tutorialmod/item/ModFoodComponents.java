package net.toby.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent HEART = new FoodComponent.Builder().nutrition(5).saturationModifier(0.3f).
            statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1200), 1.00f).build();
}
