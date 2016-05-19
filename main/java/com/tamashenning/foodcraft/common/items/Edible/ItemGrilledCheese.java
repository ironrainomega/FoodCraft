package com.tamashenning.foodcraft.common.items.Edible;

import com.tamashenning.foodcraft.common.items.ItemsFoodBase;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by ironr on 5/17/2016.
 */
public class ItemGrilledCheese extends ItemsFoodBase {
    public static String unlocalizedName = "grilled_cheese";

    public ItemGrilledCheese() {
        super();
        this.setUnlocalizedName(unlocalizedName);

        this.FoodBitterModifier = 1f;
        this.FoodSweetModifier = 1f;
        this.FoodSourModifier = 1f;
        this.FoodSaltyModifier = 1f;
        this.FoodSavoryModifier = 1f;
        this.FoodSaturationAmount = 1f;

        this.FallbackHealAmount = 1;
    }
}
