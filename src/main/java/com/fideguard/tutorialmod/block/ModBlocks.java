package com.fideguard.tutorialmod.block;

import com.fideguard.tutorialmod.TutorialMod;
import com.fideguard.tutorialmod.block.custom.BounceBlock;
import com.fideguard.tutorialmod.block.custom.MagicBlock;
import com.fideguard.tutorialmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
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



    public static final RegistryObject<Block> ALEXANDRITE_ORE = registerBlock("alexandrite_ore",() -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ALEXANDRITE_DEEPSLATE_ORE = registerBlock("alexandrite_deepslate_ore",() -> new DropExperienceBlock(UniformInt.of(3,6),BlockBehaviour.Properties.of()
            .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));



    public static final RegistryObject<Block> ZEPHRYTE_BLOCK = registerBlock("zephryte_block",() -> new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.GLASS)));

    public static final RegistryObject<Block> RAW_ZEPHRYTE_BLOCK = registerBlock("raw_zephryte_block",() -> new Block(BlockBehaviour.Properties.of()
            .strength(3f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> ZEPHRYTE_ORE = registerBlock("zephryte_ore",() -> new DropExperienceBlock(UniformInt.of(3,7),BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ZEPHRYTE_DEEPSLATE_ORE = registerBlock("zephryte_deepslate_ore",() -> new DropExperienceBlock(UniformInt.of(5,7),BlockBehaviour.Properties.of()
            .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));


    public static final RegistryObject<Block> EMBERNITE_BLOCK = registerBlock("embernite_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.BASALT)));

    public static final RegistryObject<Block> RAW_EMBERNITE_BLOCK = registerBlock("raw_embernite_block",() -> new Block(BlockBehaviour.Properties.of()
            .strength(3f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> EMBERNITE_ORE = registerBlock("embernite_ore",() -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> EMBERNITE_DEEPSLATE_ORE = registerBlock("embernite_deepslate_ore",() -> new DropExperienceBlock(UniformInt.of(3,6),BlockBehaviour.Properties.of()
            .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block", () -> new MagicBlock(BlockBehaviour.Properties.of()
            .strength(2f).requiresCorrectToolForDrops().sound(SoundType.SCULK)));

    public static final RegistryObject<Block> BOUNCE_BLOCK = registerBlock("bounce_block", () -> new BounceBlock(BlockBehaviour.Properties.of()
            .strength(2f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));
    //can add noLootTable here to delete the lootTable error when running Data, and to delete the lootBox of the object



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
