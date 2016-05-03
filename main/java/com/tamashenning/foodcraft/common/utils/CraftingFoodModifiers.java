package com.tamashenning.foodcraft.common.utils;

import com.tamashenning.foodcraft.FoodCraft;
import com.tamashenning.foodcraft.common.utils.models.ModifierModel;
import com.tamashenning.foodcraft.registrations.ItemRegistrations;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;

public final class CraftingFoodModifiers {

    private static String ModifierSectionName = "Modifiers";

    // TODO: Add to configs...

    public static ModifierModel cookedMeatModifier = CraftingFoodModifiers.createModel("cookedMeat", 0f, 0.2f, 0.2f, 0.5f, 1.5f,
            8, 4f, Potion.getPotionById(0), 0f, 0);

    public static ModifierModel sugarModifier = CraftingFoodModifiers.createModel(Items.sugar, 0, 2, 0, -0.1f, 0, 1, 0,
            Potion.getPotionById(0), 0f, 0);

    public static ModifierModel rottenFleshModifier = CraftingFoodModifiers.createModel(Items.rotten_flesh, -1, -1, -1,
            -1, -1, -1, -1, Potion.getPotionById(17), 0.8f, 300);

    public static ModifierModel poisonousPotatoModifier = CraftingFoodModifiers.createModel(Items.poisonous_potato, -1,
            -1, -1, -1, -1, -1, -1, Potion.getPotionById(19), 0.6f, 100);

    public static ModifierModel spiderEyeModifier = CraftingFoodModifiers.createModel(Items.spider_eye, -2, -2, -2, -2,
            -2, -2, -2, Potion.getPotionById(19), 1f, 100);

    public static ModifierModel saltModifier = CraftingFoodModifiers.createModel(ItemRegistrations.saltItem, 0, 0, 0, 2f,
            -2f, 0, 0, Potion.getPotionById(0), 0f, 0);

    public static ModifierModel createModel(Object item, float bitter, float sweet, float sour, float salty,
                                            float savory, int heal, float saturation, Potion potionID, float potionProbability, int potionLength) {

        String itemName = "";
        if (item instanceof ItemStack) {
            itemName = ((ItemStack) item).getUnlocalizedName();
        } else if (item instanceof Item) {
            itemName = ((Item) item).getUnlocalizedName();
        } else if (item instanceof Block) {
            itemName = ((Block) item).getUnlocalizedName();
        } else if (item instanceof String) {
            itemName = "oreDict." + (String) item;
        }


        ModifierModel model = new ModifierModel();
        String categoryName = CraftingFoodModifiers.ModifierSectionName +"."+ itemName;

        FoodCraft.config.setCategoryComment(categoryName, "Modifiers for "+itemName);
        model.BitterModifier = FoodCraft.config.getFloat("modifier." + itemName + ".tasteBitter", categoryName, bitter, 0, 5, "");
        model.SweetModifier = FoodCraft.config.getFloat("modifier." + itemName + ".tasteSweet", categoryName, sweet, 0, 5, "");
        model.SourModifier = FoodCraft.config.getFloat("modifier." + itemName + ".tasteSour", categoryName, sour, 0, 5, "");
        model.SaltyModifier = FoodCraft.config.getFloat("modifier." + itemName + ".tasteSalty", categoryName, salty, 0, 5, "");
        model.SavoryModifier = FoodCraft.config.getFloat("modifier." + itemName + ".tasteSavory", categoryName, savory, 0, 5, "");

        model.HealModifier = FoodCraft.config.get(categoryName, "modifier." + itemName + ".statsHeal", heal).getInt();
        model.SaturationModifier = FoodCraft.config.getFloat("modifier." + itemName + ".statsSaturation", categoryName, saturation, 0, 20, "");

        model.PotionId = potionID.getPotionById(FoodCraft.config.get(categoryName, "modifier." + itemName + ".potionID", Potion.getIdFromPotion(potionID)).getInt());
        model.PotionPorbability = FoodCraft.config.getFloat("modifier." + itemName + ".potionProbability", categoryName, potionProbability, 0, 1, "");
        model.PotionLength = FoodCraft.config.get(categoryName, "modifier." + itemName + ".potionLength", potionLength).getInt();

        model.item = item;
        return model;

    }
}
