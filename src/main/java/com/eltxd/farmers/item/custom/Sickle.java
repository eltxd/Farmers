package com.eltxd.farmers.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class Sickle extends Item {
    public static List<Item> LIST_OF_SEEDS = new ArrayList<>();

    static {
        LIST_OF_SEEDS.add(Items.WHEAT_SEEDS);
        LIST_OF_SEEDS.add(Items.CARROT);
        LIST_OF_SEEDS.add(Items.BEETROOT_SEEDS);
        LIST_OF_SEEDS.add(Items.POTATO);

    }


    public Sickle(Settings settings) {



        super(settings);
    }



    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getStack();

        if (!world.isClient && player != null) {
            harvestArea((ServerWorld) world, pos, player, stack);
            context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    private void harvestArea(ServerWorld world, BlockPos pos, PlayerEntity player, ItemStack stack) {
        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        if (block instanceof CropBlock crop) {
            if (state.get(CropBlock.AGE) == crop.getMaxAge()) {
                world.breakBlock(pos, true); // Drop crops
                if (player.getOffHandStack().getItem() == LIST_OF_SEEDS)
                    world.setBlockState(pos, crop.getDefaultState()); // Replant
                if (state.get(CropBlock.AGE) != crop.getMaxAge()) {
                    world.breakBlock(pos, false);

                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.farmers.sickle_shift1.tooltip"));
            tooltip.add(Text.translatable("tooltip.farmers.sickle_shift2.tooltip"));
        } else {
            tooltip.add(Text.translatable("tooltip.farmers.sickle.tooltip"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
