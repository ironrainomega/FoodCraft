package com.tamashenning.foodcraft.common.items.Edible;

import com.tamashenning.foodcraft.common.items.ItemsFoodBase;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSoup extends ItemsFoodBase {

	public static String unlocalizedName = "soup";

	public ItemSoup() {
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setAlwaysEdible();

		this.FoodBitterModifier = 1f;
		this.FoodSweetModifier = 1f;
		this.FoodSourModifier = 1f;
		this.FoodSaltyModifier = 1f;
		this.FoodSavoryModifier = 1f;
		this.FoodSaturationAmount = 1f;

		this.FallbackHealAmount = 1;
	}

}
