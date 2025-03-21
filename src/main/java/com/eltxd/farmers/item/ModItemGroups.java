package com.eltxd.farmers.item;

import com.eltxd.farmers.Farmers;
import com.eltxd.farmers.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup FARMERS_INGREDIENTS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Farmers.MOD_ID, "farmers_ingredients"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PALM_SUGAR))
                    .displayName(Text.translatable("itemgroup.farmers.farmers_ingredients"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PALM_SUGAR);
                        entries.add(ModItems.RAW_PALM_SUGAR);
                        entries.add(ModItems.CHEMICAL_FERTILIZER);


                    }).build());

    public static final ItemGroup FARMERS_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Farmers.MOD_ID, "farmers_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.COCONUT_TREE_LOG))
                    .displayName(Text.translatable("itemgroup.farmers.farmers_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.COCONUT_TREE_LOG);
                        entries.add(ModBlocks.PALM_SUGAR_ORE);
                        entries.add(ModBlocks.PALM_SUGAR_BLOCK);

                    }).build());

    public static final ItemGroup FARMERS_GADGETS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Farmers.MOD_ID, "farmers_gadgets"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.HYDROPONIC_GROWTH_BLOCK))
                    .displayName(Text.translatable("itemgroup.farmers.farmers_gadgets"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.HYDROPONIC_GROWTH_BLOCK);

                    }).build());


    public static final ItemGroup FARMERS_TOOLS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Farmers.MOD_ID, "farmers_tools"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SICKLE))
                    .displayName(Text.translatable("itemgroup.farmers.farmers_tools"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SICKLE);

                    }).build());

    public static final ItemGroup FARMERS_FOODS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Farmers.MOD_ID, "farmers_foods"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BERRY_PIE))
                    .displayName(Text.translatable("itemgroup.farmers.farmers_foods"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BERRY_PIE);

                    }).build());

    public static final ItemGroup FARMERS_FUELS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Farmers.MOD_ID, "farmers_fuels"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.STRAW_BALE))
                    .displayName(Text.translatable("itemgroup.farmers.farmers_fuels"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.STRAW_BALE);

                    }).build());

    public static void registerItemGroups() {
        Farmers.LOGGER.info("Registering Mod Item Groups for " + Farmers.MOD_ID);
    }
}
