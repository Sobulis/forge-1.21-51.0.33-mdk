package com.fideguard.tutorialmod.util;

import com.fideguard.tutorialmod.TutorialMod;
import com.fideguard.tutorialmod.component.ModDataComponentTypes;
import com.fideguard.tutorialmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomProperties(){
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "used"),
                (itemStack, clientLevel, livingEntity, i) -> itemStack.get(ModDataComponentTypes.COORDINATES.get()) != null ? 1f: 0f);
    }
}
