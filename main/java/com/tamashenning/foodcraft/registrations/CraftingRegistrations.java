package com.tamashenning.foodcraft.registrations;

import com.tamashenning.foodcraft.common.blocks.FoodCraftBlocks;
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

        // Soup recipe
        GameRegistry.addShapelessRecipe(new ItemStack(FoodCraftItems.SOUP_ITEM.item, 3),
                Items.BONE, Items.BOWL, Items.WATER_BUCKET);

        registerModifiers(FoodCraftItems.SOUP_ITEM.item, CraftingFoodModifiers.cookedMeatModifier, CraftingFoodModifiers.poisonousPotatoModifier,
                CraftingFoodModifiers.rottenFleshModifier, CraftingFoodModifiers.spiderEyeModifier,
                CraftingFoodModifiers.sugarModifier, CraftingFoodModifiers.saltModifier);


        // Mashed potato recipe
        GameRegistry.addShapelessRecipe(new ItemStack(FoodCraftItems.MASHED_POTATO_ITEM.item, 8), Items.BAKED_POTATO, Items.BOWL, Items.STICK, FoodCraftItems.BUTTER_ITEM.item, Items.MILK_BUCKET);
        registerModifiers(FoodCraftItems.MASHED_POTATO_ITEM.item, CraftingFoodModifiers.baconModifier, CraftingFoodModifiers.rottenFleshModifier, CraftingFoodModifiers.spiderEyeModifier, CraftingFoodModifiers.cheeseModifier, CraftingFoodModifiers.appleModifier);

        // Cheese recipe
        GameRegistry.addShapelessRecipe(new ItemStack(FoodCraftItems.CHEESE_ITEM.item), Items.MILK_BUCKET,
                FoodCraftItems.SALT_ITEM.item);

        // Compressed cheese...
        GameRegistry.addShapelessRecipe(new ItemStack(FoodCraftItems.CHEESE_ITEM.item, 9), FoodCraftBlocks.CHEESE_BLOCK.block);
        GameRegistry.addRecipe(new ItemStack(FoodCraftBlocks.CHEESE_BLOCK.block), new Object[] {"###", "###", "###" , '#', FoodCraftItems.CHEESE_ITEM.item});

        // Butter recipe
        GameRegistry.addShapelessRecipe(new ItemStack(FoodCraftItems.BUTTER_ITEM.item), Items.MILK_BUCKET,
                FoodCraftItems.SALT_ITEM.item, Items.STICK);

        // Dinner recipe
        GameRegistry.addRecipe(new FoodRecipe(new ItemStack(FoodCraftItems.DINNER_ITEM.item), FoodCraftItems.SOUP_ITEM.item, FoodCraftItems.MASHED_POTATO_ITEM.item, Items.CAKE));

        // Add compressed salt...
        GameRegistry.addShapelessRecipe(new ItemStack(FoodCraftItems.SALT_ITEM.item, 9), FoodCraftBlocks.SALT_BLOCK.block);
        GameRegistry.addRecipe(new ItemStack(FoodCraftBlocks.SALT_BLOCK.block), new Object[] {"###", "###", "###" , '#', FoodCraftItems.SALT_ITEM.item});

        // Salt recipe
        GameRegistry.addSmelting(FoodCraftBlocks.SALT_ORE.block, new ItemStack(FoodCraftItems.SALT_ITEM.item, 8), 0.5f);

        // Toast recipe
        GameRegistry.addSmelting(Items.BREAD, new ItemStack(FoodCraftItems.TOAST_ITEM.item), 0.5f);

        // Grilled cheese recipe
        GameRegistry.addShapelessRecipe(new ItemStack(FoodCraftItems.GRILLED_CHEESE_ITEM.item), FoodCraftItems.TOAST_ITEM.item,
                FoodCraftItems.TOAST_ITEM.item, FoodCraftItems.CHEESE_ITEM.item);

    }

    private static void registerModifiers(Item baseItem, ModifierModel... modifiers) {
        for (int i = 0; i < modifiers.length; i++) {
            GameRegistry.addRecipe(FoodRecipe.createRecipe(new ItemStack(baseItem), modifiers[i],
                    baseItem, modifiers[i].item));
        }
    }
}
