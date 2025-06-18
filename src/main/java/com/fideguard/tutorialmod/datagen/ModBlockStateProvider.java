package com.fideguard.tutorialmod.datagen;

import com.fideguard.tutorialmod.TutorialMod;
import com.fideguard.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.RAW_ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.EMBERNITE_BLOCK);
        blockWithItem(ModBlocks.RAW_EMBERNITE_BLOCK);
        blockWithItem(ModBlocks.ZEPHRYTE_BLOCK);
        blockWithItem(ModBlocks.RAW_ZEPHRYTE_BLOCK);

        blockWithItem(ModBlocks.ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.EMBERNITE_ORE);
        blockWithItem(ModBlocks.EMBERNITE_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.ZEPHRYTE_ORE);
        blockWithItem(ModBlocks.ZEPHRYTE_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.BOUNCE_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
