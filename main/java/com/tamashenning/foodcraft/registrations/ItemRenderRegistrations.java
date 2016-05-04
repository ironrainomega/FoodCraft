package com.tamashenning.foodcraft.registrations;

import com.tamashenning.foodcraft.FoodCraft;

import com.tamashenning.foodcraft.common.items.FoodCraftItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ItemRenderRegistrations {

    public static void registerItemRenderer() {
        FoodCraftItems.registerRenders();
    }

}
