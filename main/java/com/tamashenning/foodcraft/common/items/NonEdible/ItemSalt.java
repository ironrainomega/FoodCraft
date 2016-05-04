package com.tamashenning.foodcraft.common.items.NonEdible;

import com.tamashenning.foodcraft.common.items.ItemsBase;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSalt extends ItemsBase {
	
	public static String unlocalizedName = "salt";

	public ItemSalt() {
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabFood);
	}
}
