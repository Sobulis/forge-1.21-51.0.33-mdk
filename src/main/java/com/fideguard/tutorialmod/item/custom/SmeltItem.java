package com.fideguard.tutorialmod.item.custom;

import com.fideguard.tutorialmod.block.ModBlocks;
import com.fideguard.tutorialmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

public class SmeltItem extends Item {

    public static final Map<Block, Item> SMELT_MAP =
            Map.ofEntries(
                Map.entry(Blocks.IRON_ORE, Items.IRON_INGOT),
                Map.entry(Blocks.GOLD_ORE, Items.GOLD_INGOT),
                Map.entry(Blocks.COPPER_ORE, Items.COPPER_INGOT),
                Map.entry(Blocks.DEEPSLATE_COPPER_ORE, Items.COPPER_INGOT),
                Map.entry(Blocks.DEEPSLATE_GOLD_ORE, Items.GOLD_INGOT),
                Map.entry(Blocks.DEEPSLATE_IRON_ORE, Items.IRON_INGOT),
                Map.entry(Blocks.NETHER_GOLD_ORE, Items.GOLD_INGOT),
                Map.entry(ModBlocks.ALEXANDRITE_ORE.get(), ModItems.ALEXANDRITE.get()),
                Map.entry(ModBlocks.ZEPHRYTE_ORE.get(), ModItems.ZEPHRYTE.get()),
                Map.entry(ModBlocks.EMBERNITE_ORE.get(), ModItems.EMBERNITE.get()),
                Map.entry(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get(), ModItems.ALEXANDRITE.get()),
                Map.entry(ModBlocks.EMBERNITE_DEEPSLATE_ORE.get(), ModItems.EMBERNITE.get()),
                Map.entry(ModBlocks.ZEPHRYTE_DEEPSLATE_ORE.get(), ModItems.ZEPHRYTE.get())
    );


    public SmeltItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        Level level = pContext.getLevel();
        BlockState state = level.getBlockState(pContext.getClickedPos());
        Block clickedBlock = state.getBlock();

        if(SMELT_MAP.containsKey(clickedBlock)){
            if(!level.isClientSide()){
                ServerLevel serverLevel = (ServerLevel) level;
                ServerPlayer player = (ServerPlayer) pContext.getPlayer();

                serverLevel.removeBlock(pContext.getClickedPos(),false);

                ItemStack result = new ItemStack(SMELT_MAP.get(clickedBlock));
                Block.popResource(level, pContext.getClickedPos(),result);

                level.playSound(null, pContext.getClickedPos(), SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS);
                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
            }
        }

        return InteractionResult.SUCCESS;
    }
}
