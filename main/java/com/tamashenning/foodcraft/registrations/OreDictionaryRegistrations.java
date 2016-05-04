package com.tamashenning.foodcraft.registrations;

import com.tamashenning.foodcraft.FoodCraft;
import com.tamashenning.foodcraft.common.items.FoodCraftItems;
import net.minecraft.init.Items;
import net.minecraftforge.oredict.OreDictionary;

public final class OreDictionaryRegistrations {
    public static void init() {

        OreDictionary.registerOre("cookedMeat", Items.cooked_beef);
        OreDictionary.registerOre("cookedMeat", Items.cooked_chicken);
        OreDictionary.registerOre("cookedMeat", Items.cooked_fish);
        OreDictionary.registerOre("cookedMeat", Items.cooked_mutton);
        OreDictionary.registerOre("cookedMeat", Items.cooked_porkchop);
        OreDictionary.registerOre("cookedMeat", Items.cooked_rabbit);

        OreDictionary.registerOre("rawMeat", Items.beef);
        OreDictionary.registerOre("rawMeat", Items.chicken);
        OreDictionary.registerOre("rawMeat", Items.fish);
        OreDictionary.registerOre("rawMeat", Items.mutton);
        OreDictionary.registerOre("rawMeat", Items.porkchop);
        OreDictionary.registerOre("rawMeat", Items.rabbit);

        OreDictionary.registerOre("salt", FoodCraftItems.SALT_ITEM.item);
        OreDictionary.registerOre("cheese", FoodCraftItems.CHEESE_ITEM.item);
    }
}
