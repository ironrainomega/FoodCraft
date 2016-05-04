package com.tamashenning.foodcraft.registrations;

import com.tamashenning.foodcraft.FoodCraft;
import com.tamashenning.foodcraft.common.items.*;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ItemRegistrations {

    @SuppressWarnings("deprecation")
    public static final void init() {
        FoodCraftItems.registerItems();
    }

}
