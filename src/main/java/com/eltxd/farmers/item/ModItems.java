package com.eltxd.farmers.item;

import com.eltxd.farmers.Farmers;
import com.eltxd.farmers.block.ModBlocks;
import com.eltxd.farmers.item.custom.ChemicalFertilizer;
import com.eltxd.farmers.item.custom.ModFoodComponents;
import com.eltxd.farmers.item.custom.Sickle;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item PALM_SUGAR = registerItem("palm_sugar", new Item(new Item.Settings()));
    public static final Item RAW_PALM_SUGAR = registerItem("raw_palm_sugar", new Item(new Item.Settings()));
    public static final Item CHEMICAL_FERTILIZER = registerItem("chemical_fertilizer", new ChemicalFertilizer(new Item.Settings()));

    public static final Item SICKLE = registerItem("sickle", new Sickle(new Item.Settings().maxDamage(90)));

    public static final Item BERRY_PIE = registerItem("berry_pie", new Item(new Item.Settings().food(ModFoodComponents.BERRY_PIE)));

    public static final Item STRAW_BALE = registerItem("straw_bale", new Item(new Item.Settings()));

    public static final Item RICE_SEED = registerItem("rice_seed", new AliasedBlockItem(ModBlocks.RICE_CROP, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Farmers.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Farmers.LOGGER.info("Registering Mod Items for " + Farmers.MOD_ID);
    }
}
