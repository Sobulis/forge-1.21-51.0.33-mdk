package com.fideguard.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    //fast method - allows for fast consumption
    //usingConvertsTo method - converts food into another item upon consumption (stew bowl -> bowl)
    //alwaysEdible method - the food is always edible
    public static final FoodProperties KOHLRABI = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.INVISIBILITY,400),0.25f).build();

    public static final FoodProperties GRAPE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f)
            .effect(new MobEffectInstance(MobEffects.CONFUSION,150),0.75f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200,2),0.5f)
            .effect(new MobEffectInstance(MobEffects.BLINDNESS,150),1.0f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300,2),0.9f).build();
}

/* For Drink food:
- need to make a custom item class for that specific drink (drink item)
- inside of it, you want to write this code:
    @Override
    public UseAnim getUseAnimation(ItemStack pStack){
        return useAnim.DRINK;
- instead of new Item it would be new DrinkItem, or whatever class is created
 */