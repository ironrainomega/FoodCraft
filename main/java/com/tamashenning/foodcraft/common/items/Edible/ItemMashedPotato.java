
package com.tamashenning.foodcraft.common.items.Edible;

import com.tamashenning.foodcraft.common.items.ItemsFoodBase;
import net.minecraft.creativetab.CreativeTabs;

public class ItemMashedPotato extends ItemsFoodBase {

    public static String unlocalizedName = "mashed_potato";

    public ItemMashedPotato() {
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
