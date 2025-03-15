package com.eltxd.farmers.item;

import com.eltxd.farmers.Farmers;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item PALM_SUGAR = registerItem("palm_sugar", new Item(new Item.Settings()));
    public static final Item RAW_PALM_SUGAR = registerItem("raw_palm_sugar", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Farmers.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Farmers.LOGGER.info("Registering Mod Items for " + Farmers.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(PALM_SUGAR);
            fabricItemGroupEntries.add(RAW_PALM_SUGAR);
        });
    }
}
