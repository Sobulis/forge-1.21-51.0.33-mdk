package com.fideguard.tutorialmod.item;

import com.fideguard.tutorialmod.TutorialMod;
import com.fideguard.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PERFECTIVE_ITEMS_TAB = CREATIVE_MODE_TABS.register("perfective_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                    .title(Component.translatable("creativetab.tutorialmod.perfective_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ALEXANDRITE.get());
                        output.accept(ModItems.RAW_ALEXANDRITE.get());
                        output.accept(ModItems.RAW_ZEPHRYTE.get());
                        output.accept(ModItems.ZEPHRYTE.get());
                        output.accept(ModItems.EMBERNITE.get());
                        output.accept(ModItems.RAW_EMBERNITE.get());

                        output.accept(ModItems.ZEPHRYTE_NUGGET.get());

                        output.accept(ModItems.CHISEL.get());
                        output.accept(ModItems.SMELT_TORCH.get());

                        output.accept(ModItems.BOUNCE_BALL.get());

                        output.accept(ModItems.KOHLRABI.get());
                        output.accept(ModItems.GRAPE.get());

                        output.accept(ModItems.AURORA_ASHES.get());
                        output.accept(ModItems.CHARRED_STICK.get());

                        output.accept(ModItems.KAUPEN_SMITHING_TEMPLATE.get());
                        output.accept(ModItems.BAR_BRAWL_MUSIC_DISC.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> PERFECTIVE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("perfective_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
                    .withTabsBefore(PERFECTIVE_ITEMS_TAB.getId()) //Define tabs that should come before this tab. This tab will be placed after the tabs.
                    .title(Component.translatable("creativetab.tutorialmod.perfective_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ZEPHRYTE_BLOCK.get());
                        output.accept(ModBlocks.ZEPHRYTE_BLOCK.get());
                        output.accept(ModBlocks.EMBERNITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_EMBERNITE_BLOCK.get());

                        output.accept(ModBlocks.ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.EMBERNITE_ORE.get());
                        output.accept(ModBlocks.EMBERNITE_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.ZEPHRYTE_ORE.get());
                        output.accept(ModBlocks.ZEPHRYTE_DEEPSLATE_ORE.get());

                        output.accept(ModBlocks.MAGIC_BLOCK.get());
                        output.accept(ModBlocks.BOUNCE_BLOCK.get());

                        output.accept(ModBlocks.ALEXANDRITE_STAIRS.get());
                        output.accept(ModBlocks.ALEXANDRITE_SLAB.get());
                        output.accept(ModBlocks.ALEXANDRITE_FENCE.get());
                        output.accept(ModBlocks.ALEXANDRITE_FENCE_GATE.get());
                        output.accept(ModBlocks.ALEXANDRITE_WALL.get());
                        output.accept(ModBlocks.ALEXANDRITE_DOOR.get());
                        output.accept(ModBlocks.ALEXANDRITE_TRAPDOOR.get());
                        output.accept(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ALEXANDRITE_BUTTON.get());

                        output.accept(ModBlocks.ALEXADNRITE_LAMP.get());
                        output.accept(ModBlocks.EMBERNITE_LAMP.get());


                    }).build());

    public static final RegistryObject<CreativeModeTab> PERFECTIVE_TOOLS_TAB = CREATIVE_MODE_TABS.register("perfective_tools_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ALEXANDRITE_SWORD.get()))
                    .withTabsBefore(PERFECTIVE_BLOCKS_TAB.getId()) //Define tabs that should come before this tab. This tab will be placed after the tabs.
                    .title(Component.translatable("creativetab.tutorialmod.perfective_tools"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ALEXANDRITE_SWORD.get());
                        output.accept(ModItems.ALEXANDRITE_PICKAXE.get());
                        output.accept(ModItems.ALEXANDRITE_AXE.get());
                        output.accept(ModItems.ALEXANDRITE_SHOVEL.get());
                        output.accept(ModItems.ALEXANDRITE_HOE.get());
                        output.accept(ModItems.ALEXANDRITE_HAMMER.get());

                        output.accept(ModItems.FIDEGUARD_BOW.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> PERFECTIVE_ARMOR_TAB = CREATIVE_MODE_TABS.register("perfective_armor_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ALEXANDRITE_CHESTPLATE.get()))
                    .withTabsBefore(PERFECTIVE_TOOLS_TAB.getId()) //Define tabs that should come before this tab. This tab will be placed after the tabs.
                    .title(Component.translatable("creativetab.tutorialmod.perfective_armor"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ALEXANDRITE_HELMET.get());
                        output.accept(ModItems.ALEXANDRITE_CHESTPLATE.get());
                        output.accept(ModItems.ALEXANDRITE_LEGGINGS.get());
                        output.accept(ModItems.ALEXANDRITE_BOOTS.get());

                        output.accept(ModItems.ALEXANDRITE_HORSE_ARMOR.get());

                    }).build());







    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
