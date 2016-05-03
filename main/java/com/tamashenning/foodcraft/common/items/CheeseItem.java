package com.tamashenning.foodcraft.common.items;

import net.minecraft.creativetab.CreativeTabs;

public class CheeseItem extends ItemsBase {
	public static String unlocalizedName = "cheese";

	public CheeseItem() {
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabFood);
	}
}
