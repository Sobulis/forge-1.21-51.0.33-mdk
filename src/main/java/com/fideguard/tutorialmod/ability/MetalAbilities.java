package com.fideguard.tutorialmod.ability;

import com.fideguard.tutorialmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class MetalAbilities {

    private static final double RANGE = 5.5;

    public static void applyMetalAbility(Player player, boolean isPulling) {
        Level world = player.level();
        BlockPos origin = player.blockPosition();

        AABB box = new AABB(origin).inflate(RANGE);
        Vec3 playerCenter = player.position().add(0, player.getEyeHeight(), 0);

        // 1. Affect ItemEntities (floating metal items)
        List<ItemEntity> itemEntities = world.getEntitiesOfClass(ItemEntity.class, box, entity ->
                entity.getItem().is(ModTags.Items.METAL_ITEMS));

        for (ItemEntity itemEntity : itemEntities) {
            Vec3 dir = itemEntity.position().subtract(playerCenter).normalize();
            if (isPulling) dir = dir.scale(-1); // reverse

            itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add(dir.scale(0.3)));
            itemEntity.hasImpulse = true;
        }

        // 2. Affect Blocks (if metal blocks are in tag)
        for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-5, -5, -5), origin.offset(5, 5, 5))) {
            BlockState state = world.getBlockState(pos);
            if (!state.is(ModTags.Blocks.METAL_BLOCKS)) continue;

            Vec3 blockCenter = Vec3.atCenterOf(pos);
            Vec3 direction = blockCenter.subtract(playerCenter).normalize();


            // Blocks are heavy: pull player instead
            Vec3 pull = direction.scale(0.7);
            player.push(pull.x, pull.y * 0.5, pull.z);
            player.hasImpulse = true;




        }
    }
}
