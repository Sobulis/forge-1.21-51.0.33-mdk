package com.fideguard.tutorialmod.item;

import com.fideguard.tutorialmod.TutorialMod;
import com.fideguard.tutorialmod.item.custom.ChiselItem;
import com.fideguard.tutorialmod.item.custom.FuelItem;
import com.fideguard.tutorialmod.item.custom.SmeltItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.internal.ForgeBindings;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    //register our items
    //List of our items with our MOD_ID, and will be registered at the right time
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    //Now we can actually register our item
    //Bare-bone new item without an actual texture, and cannot be found in any creative menu's
    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZEPHRYTE = ITEMS.register("zephryte",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ZEPHRYTE = ITEMS.register("raw_zephryte", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMBERNITE = ITEMS.register("embernite",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_EMBERNITE = ITEMS.register("raw_embernite", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZEPHRYTE_NUGGET = ITEMS.register("zephryte_nugget",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BOUNCE_BALL = ITEMS.register("bounce_ball", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel", () -> new ChiselItem(new Item.Properties().durability(32)));
    public static final RegistryObject<Item> SMELT_TORCH = ITEMS.register("smelt_torch", () -> new SmeltItem(new Item.Properties().durability(16)));

    public static final RegistryObject<Item> KOHLRABI = ITEMS.register("kohlrabi",() -> new Item(new Item.Properties().food(ModFoodProperties.KOHLRABI)) { //Use anonymous class
        @Override
        public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
            pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.kohlrabi"));
            super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        }
    });

    public static final RegistryObject<Item> GRAPE = ITEMS.register("grape", () -> new Item(new Item.Properties().food(ModFoodProperties.GRAPE)) {
        @Override
        public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
            pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.grape"));
            super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        }
    });

    public static final RegistryObject<Item> AURORA_ASHES = ITEMS.register("aurora_ashes",() -> new FuelItem(new Item.Properties(), 1800));
    public static final RegistryObject<Item> CHARRED_STICK = ITEMS.register("charred_stick",() -> new FuelItem(new Item.Properties(),800));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
