package com.fideguard.tutorialmod.datagen;

import com.fideguard.tutorialmod.TutorialMod;
import com.fideguard.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_ALEXANDRITE.get());
        basicItem(ModItems.ALEXANDRITE.get());
        basicItem(ModItems.RAW_ZEPHRYTE.get());
        basicItem(ModItems.ZEPHRYTE.get());
        basicItem(ModItems.EMBERNITE.get());
        basicItem(ModItems.RAW_EMBERNITE.get());
        basicItem(ModItems.ZEPHRYTE_NUGGET.get());

        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.SMELT_TORCH.get());

        basicItem(ModItems.KOHLRABI.get());
        basicItem(ModItems.GRAPE.get());

        basicItem(ModItems.AURORA_ASHES.get());
        basicItem(ModItems.CHARRED_STICK.get());
        basicItem(ModItems.BOUNCE_BALL.get());

    }
}
