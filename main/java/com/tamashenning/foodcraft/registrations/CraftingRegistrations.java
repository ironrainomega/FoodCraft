package com.tamashenning.foodcraft.registrations;

import com.tamashenning.foodcraft.common.utils.CraftingFoodModifiers;
import com.tamashenning.foodcraft.common.utils.models.ModifierModel;
import com.tamashenning.foodcraft.recipe.FoodRecipe;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class CraftingRegistrations {

	public static final void init() {
		GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistrations.soupItem, 3),
				new Object[] { Items.bone, Items.bowl, Items.water_bucket });

		registerSoups(CraftingFoodModifiers.cookedMeatModifier, CraftingFoodModifiers.poisonousPotatoModifier,
				CraftingFoodModifiers.rottenFleshModifier, CraftingFoodModifiers.spiderEyeModifier,
				CraftingFoodModifiers.sugarModifier, CraftingFoodModifiers.saltModifier);

		// TODO: Figure out how to give bucket back... Maybe...
		GameRegistry.addSmelting(Items.water_bucket, new ItemStack(ItemRegistrations.saltItem, 16), 0.5f);

		GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistrations.cheeseItem), Items.milk_bucket,
				ItemRegistrations.saltItem);

	}

	private static void registerSoups(ModifierModel... modifiers) {
		for (int i = 0; i < modifiers.length; i++) {
			GameRegistry.addRecipe(FoodRecipe.createRecipe(new ItemStack(ItemRegistrations.soupItem), modifiers[i],
					ItemRegistrations.soupItem, modifiers[i].item));
		}
	}
}
