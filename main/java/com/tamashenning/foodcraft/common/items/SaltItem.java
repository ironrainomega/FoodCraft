package com.tamashenning.foodcraft.common.items;

import net.minecraft.creativetab.CreativeTabs;

public class SaltItem extends ItemsBase {
	
	public static String unlocalizedName = "salt";

	public SaltItem() {
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabFood);
	}
}
