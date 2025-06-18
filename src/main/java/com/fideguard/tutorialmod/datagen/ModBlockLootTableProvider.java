package com.fideguard.tutorialmod.datagen;

import com.fideguard.tutorialmod.block.ModBlocks;
import com.fideguard.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;


import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        //Loot table for blocks that drop itself
        dropSelf(ModBlocks.ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());
        dropSelf(ModBlocks.ZEPHRYTE_BLOCK.get());
        dropSelf(ModBlocks.RAW_ZEPHRYTE_BLOCK.get());
        dropSelf(ModBlocks.EMBERNITE_BLOCK.get());
        dropSelf(ModBlocks.RAW_EMBERNITE_BLOCK.get());
        dropSelf(ModBlocks.BOUNCE_BLOCK.get());

        //Ores
        this.add(ModBlocks.ALEXANDRITE_ORE.get(),
                block -> createOreDrop(ModBlocks.ALEXANDRITE_ORE.get(), ModItems.RAW_ALEXANDRITE.get()));
        this.add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get(), ModItems.RAW_ALEXANDRITE.get(), 2, 5));
        this.add(ModBlocks.EMBERNITE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.EMBERNITE_DEEPSLATE_ORE.get(), ModItems.RAW_EMBERNITE.get(), 2, 4));
        this.add(ModBlocks.ZEPHRYTE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.ZEPHRYTE_DEEPSLATE_ORE.get(), ModItems.ZEPHRYTE.get(), 1, 3));
        this.add(ModBlocks.EMBERNITE_ORE.get(),
                block -> createOreDrop(ModBlocks.EMBERNITE_ORE.get(), ModItems.RAW_EMBERNITE.get()));
        this.add(ModBlocks.ZEPHRYTE_ORE.get(),
                block -> createOreDrop(ModBlocks.ZEPHRYTE_ORE.get(), ModItems.RAW_ZEPHRYTE.get()));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator; //Making all the blocks we created available to the class
    }
}
