package com.eltxd.farmers.block;

import com.eltxd.farmers.Farmers;
import com.eltxd.farmers.block.custom.HydroponicGrowthBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block COCONUT_TREE_LOG = registerBlock("coconut_tree_log",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.WOOD)));

    public static final Block PALM_SUGAR_BLOCK = registerBlock("palm_sugar_block",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.SLIME)));

    public static final Block HYDROPONIC_GROWTH_BLOCK = registerBlock("hydroponic_growth_block",
            new HydroponicGrowthBlock(AbstractBlock.Settings.create()));

    public static final Block PALM_SUGAR_ORE = registerBlock("palm_sugar_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Farmers.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Farmers.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Farmers.LOGGER.info("Registering Mod Block for " + Farmers.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(COCONUT_TREE_LOG);
            fabricItemGroupEntries.add(PALM_SUGAR_ORE);
            fabricItemGroupEntries.add(PALM_SUGAR_BLOCK);

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(HYDROPONIC_GROWTH_BLOCK);
        });
    }
}
