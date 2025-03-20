package com.eltxd.farmers.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ChemicalFertilizer extends Item {

    public ChemicalFertilizer(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        BlockState blockState = world.getBlockState(blockPos);

        if (blockState.getBlock() instanceof CropBlock cropBlock) {
            int currentAge = blockState.get(CropBlock.AGE);
            int maxAge = cropBlock.getMaxAge();

            if (currentAge < maxAge) {
                if (isValidCropblock(blockState.getProperties()))
                int newAge = Math.min(currentAge + 7, maxAge); // Ensure it does not exceed max age
                world.setBlockState(blockPos, blockState.with(CropBlock.AGE, newAge), 2);

                if (player != null) {
                    Hand hand = context.getHand();
                    ItemStack stack = player.getStackInHand(hand);
                    stack.decrement(1);
                }

                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS;
    }
}