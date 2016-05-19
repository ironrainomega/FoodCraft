package com.tamashenning.foodcraft.registrations;

import com.tamashenning.foodcraft.FoodCraft;
import com.tamashenning.foodcraft.common.items.FoodCraftItems;
import net.minecraft.init.Items;
import net.minecraftforge.oredict.OreDictionary;

public final class OreDictionaryRegistrations {
    public static void init() {

        OreDictionary.registerOre("cookedMeat", Items.COOKED_BEEF);
        OreDictionary.registerOre("cookedMeat", Items.COOKED_CHICKEN);
        OreDictionary.registerOre("cookedMeat", Items.COOKED_FISH);
        OreDictionary.registerOre("cookedMeat", Items.COOKED_MUTTON);
        OreDictionary.registerOre("cookedMeat", Items.COOKED_PORKCHOP);
        OreDictionary.registerOre("cookedMeat", Items.COOKED_RABBIT);

        OreDictionary.registerOre("rawMeat", Items.BEEF);
        OreDictionary.registerOre("rawMeat", Items.CHICKEN);
        OreDictionary.registerOre("rawMeat", Items.FISH);
        OreDictionary.registerOre("rawMeat", Items.MUTTON);
        OreDictionary.registerOre("rawMeat", Items.PORKCHOP);
        OreDictionary.registerOre("rawMeat", Items.RABBIT);

        OreDictionary.registerOre("salt", FoodCraftItems.SALT_ITEM.item);
        OreDictionary.registerOre("cheese", FoodCraftItems.CHEESE_ITEM.item);
    }
}
