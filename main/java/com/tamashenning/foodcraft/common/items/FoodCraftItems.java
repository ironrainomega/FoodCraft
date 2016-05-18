package com.tamashenning.foodcraft.common.items;

import com.tamashenning.foodcraft.common.items.Edible.*;
import com.tamashenning.foodcraft.common.items.NonEdible.ItemButter;
import com.tamashenning.foodcraft.common.items.NonEdible.ItemCheese;
import com.tamashenning.foodcraft.common.items.NonEdible.ItemSalt;
import com.tamashenning.foodcraft.common.utils.IItemRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by ironr on 5/3/2016.
 */

public enum FoodCraftItems {

    SOUP_ITEM(new ItemSoup()),
    SALT_ITEM(new ItemSalt()),
    CHEESE_ITEM(new ItemCheese()),
    BUTTER_ITEM(new ItemButter()),
    MASHED_POTATO_ITEM(new ItemMashedPotato()),
    DINNER_ITEM(new ItemDinner()),
    TOAST_ITEM(new ItemToast()),
    GRILLED_CHEESE_ITEM(new ItemGrilledCheese())
    ;

    public final Item item;

    FoodCraftItems(Item item) {
        this.item = item;
    }

    public static void registerItems() {
        for (FoodCraftItems i : FoodCraftItems.values()) {
            i.register();
        }
    }

    public static void registerRenders() {
        for (FoodCraftItems i : FoodCraftItems.values()) {
            i.registerRender();
        }
    }

    public void register() {

        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
    }

    public void registerRender() {
        if (item instanceof IItemRenderer && FMLCommonHandler.instance().getEffectiveSide().isClient()) {
            ((IItemRenderer) item).registerItemRenderer();
        }
    }
}