package com.fideguard.tutorialmod.block;

import com.fideguard.tutorialmod.TutorialMod;
import com.fideguard.tutorialmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    //Register a block - this method on its own doesn't make the block drop anything when mined
    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",() -> new Block(BlockBehaviour.Properties.of()
            .strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ZEPHRYTE_BLOCK = registerBlock("zephryte_block",() -> new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.GLASS)));

    public static final RegistryObject<Block> RAW_ZEPHRYTE_BLOCK = registerBlock("raw_zephryte_block",() -> new Block(BlockBehaviour.Properties.of()
            .strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> EMBERNITE_BLOCK = registerBlock("embernite_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.BASALT)));

    public static final RegistryObject<Block> RAW_EMBERNITE_BLOCK = registerBlock("raw_embernite_block",() -> new Block(BlockBehaviour.Properties.of()
            .strength(3f).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    //Registers blocks to items
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
