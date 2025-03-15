package com.eltxd.farmers;

import com.eltxd.farmers.block.ModBlocks;
import com.eltxd.farmers.item.ModItemGroups;
import com.eltxd.farmers.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Farmers implements ModInitializer {
	public static final String MOD_ID = "farmers";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}