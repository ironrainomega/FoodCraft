package com.tamashenning.foodcraft.common.items.NonEdible;

import com.tamashenning.foodcraft.common.items.ItemsBase;
import net.minecraft.creativetab.CreativeTabs;

public class ItemCheese extends ItemsBase {
	public static String unlocalizedName = "cheese";

	public ItemCheese() {
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.MATERIALS);
	}
}
