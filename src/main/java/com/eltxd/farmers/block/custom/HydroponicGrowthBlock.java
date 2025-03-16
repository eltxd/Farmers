package com.eltxd.farmers.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.particle.ParticleTypes;

public class HydroponicGrowthBlock extends Block {
    public HydroponicGrowthBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        // Iterate through a 3x3 area around the block
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                BlockPos checkPos = pos.add(dx, 1, dz);
                BlockState checkState = world.getBlockState(checkPos);

                // Boost crop growth if a crop is above
                if (checkState.getBlock() instanceof CropBlock crop) {
                    int currentAge = checkState.get(CropBlock.AGE);
                    if (currentAge < crop.getMaxAge() && random.nextFloat() < 0.5f) { // 50% chance
                        world.setBlockState(checkPos, checkState.with(CropBlock.AGE, currentAge + 1), 2);
                        world.addParticle(ParticleTypes.HAPPY_VILLAGER, checkPos.getX() + 0.5, checkPos.getY() + 0.5, checkPos.getZ() + 0.5, 0, 0, 0);
                    }
                }
            }
        }

        // Hydrate farmland in a 3x3 area below
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                BlockPos farmlandPos = pos.add(dx, -1, dz);
                BlockState farmlandState = world.getBlockState(farmlandPos);
                if (farmlandState.getBlock() instanceof FarmlandBlock) {
                    world.setBlockState(farmlandPos, farmlandState.with(FarmlandBlock.MOISTURE, FarmlandBlock.MAX_MOISTURE), 7);
                }
            }
        }

        // Schedule next tick
        world.scheduleBlockTick(pos, this, 20 + random.nextInt(40)); // 1-3 seconds interval
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.scheduledTick(state, world, pos, random);
    }
}
