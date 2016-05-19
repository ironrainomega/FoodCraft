package com.tamashenning.foodcraft.common.items.NonEdible;

import com.tamashenning.foodcraft.common.items.ItemsBase;
import net.minecraft.creativetab.CreativeTabs;

public class ItemButter extends ItemsBase {
    public static String unlocalizedName = "butter";

    public ItemButter() {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.MATERIALS);
    }
}
