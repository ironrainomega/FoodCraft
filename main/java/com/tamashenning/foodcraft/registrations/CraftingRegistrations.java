package com.tamashenning.foodcraft.registrations;

import com.tamashenning.foodcraft.common.items.FoodCraftItems;
import com.tamashenning.foodcraft.common.utils.CraftingFoodModifiers;
import com.tamashenning.foodcraft.common.utils.models.ModifierModel;
import com.tamashenning.foodcraft.recipe.FoodRecipe;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class CraftingRegistrations {

    public static final void init() {
        GameRegistry.addShapelessRecipe(new ItemStack(FoodCraftItems.SOUP_ITEM.item, 3),
                Items.bone, Items.bowl, Items.water_bucket);

        GameRegistry.addShapelessRecipe(new ItemStack(FoodCraftItems.MASHED_POTATO_ITEM.item, 3), Items.baked_potato, Items.bowl, Items.stick);

        registerModifiers(FoodCraftItems.SOUP_ITEM.item, CraftingFoodModifiers.cookedMeatModifier, CraftingFoodModifiers.poisonousPotatoModifier,
                CraftingFoodModifiers.rottenFleshModifier, CraftingFoodModifiers.spiderEyeModifier,
                CraftingFoodModifiers.sugarModifier, CraftingFoodModifiers.saltModifier);

        registerModifiers(FoodCraftItems.MASHED_POTATO_ITEM.item, CraftingFoodModifiers.baconModifier, CraftingFoodModifiers.rottenFleshModifier, CraftingFoodModifiers.spiderEyeModifier);

        // TODO: Figure out how to give bucket back... Maybe...
        GameRegistry.addSmelting(Items.water_bucket, new ItemStack(FoodCraftItems.SOUP_ITEM.item, 16), 0.5f);

        GameRegistry.addShapelessRecipe(new ItemStack(FoodCraftItems.CHEESE_ITEM.item), Items.milk_bucket,
                FoodCraftItems.SOUP_ITEM.item);


        GameRegistry.addRecipe(new FoodRecipe(new ItemStack(FoodCraftItems.MASHED_POTATO_ITEM.item), FoodCraftItems.SOUP_ITEM.item, FoodCraftItems.MASHED_POTATO_ITEM.item));
    }

    private static void registerModifiers(Item baseItem, ModifierModel... modifiers) {
        for (int i = 0; i < modifiers.length; i++) {
            GameRegistry.addRecipe(FoodRecipe.createRecipe(new ItemStack(baseItem), modifiers[i],
                    baseItem, modifiers[i].item));
        }
    }
}
