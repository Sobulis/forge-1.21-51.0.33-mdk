package com.fideguard.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class BounceBlock extends Block {
    public BounceBlock(Properties properties) {
        super(properties);
    }

    private void bounceUp(Entity pEntity){
        Vec3 motion = pEntity.getDeltaMovement();
        if (motion.y < 0.0){
            double damping = pEntity instanceof LivingEntity ? 1.0:0.8;
            double bounceMultiplier = 1.5;
            pEntity.setDeltaMovement(motion.x, -motion.y * damping * bounceMultiplier, motion.z);
        }
    }

    @Override
    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
        if (pEntity.isSuppressingBounce()){
            super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
        } else {
            pEntity.causeFallDamage(pFallDistance, 0.0F, pLevel.damageSources().fall());
        }
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter pLevel, Entity pEntity) {
        if (pEntity.isSuppressingBounce()){
            super.updateEntityAfterFallOn(pLevel, pEntity);
        } else {
            bounceUp(pEntity);
        }
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        double velocityY = Math.abs(pEntity.getDeltaMovement().y);
        if (velocityY < 0 && !pEntity.isSteppingCarefully()){
            double boost = 0.4 + velocityY * 0.2;
            pEntity.setDeltaMovement(pEntity.getDeltaMovement().multiply(boost, 1.0, boost));
        }
        if (!pLevel.isClientSide && pEntity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 0));
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,60, 3));
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.bounce_block"));

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
