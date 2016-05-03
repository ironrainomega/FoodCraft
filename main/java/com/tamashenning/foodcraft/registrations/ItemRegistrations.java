package com.tamashenning.foodcraft.registrations;

import com.tamashenning.foodcraft.common.items.CheeseItem;
import com.tamashenning.foodcraft.common.items.SaltItem;
import com.tamashenning.foodcraft.common.items.SoupItem;

import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ItemRegistrations {
	
	public static SoupItem soupItem = new SoupItem();
	public static SaltItem saltItem = new SaltItem();
	public static CheeseItem cheeseItem = new CheeseItem();
	
	@SuppressWarnings("deprecation")
	public static final void init() {
		
		GameRegistry.registerItem(soupItem, SoupItem.unlocalizedName);
		GameRegistry.registerItem(saltItem, SaltItem.unlocalizedName);
		GameRegistry.registerItem(cheeseItem, CheeseItem.unlocalizedName);
	}
	
}
