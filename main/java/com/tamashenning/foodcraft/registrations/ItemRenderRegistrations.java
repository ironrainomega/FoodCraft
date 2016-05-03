package com.tamashenning.foodcraft.registrations;

import com.tamashenning.foodcraft.FoodCraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class ItemRenderRegistrations {

	public static void registerItemRenderer() {
		reg(ItemRegistrations.soupItem);
		reg(ItemRegistrations.saltItem);
		reg(ItemRegistrations.cheeseItem);
	}

	public static void reg(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(FoodCraft.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
