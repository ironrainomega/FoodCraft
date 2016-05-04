package com.tamashenning.foodcraft.common.items;

import com.tamashenning.foodcraft.FoodCraft;
import com.tamashenning.foodcraft.common.utils.IItemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemsBase extends Item implements IItemRenderer {
    @SideOnly(Side.CLIENT)
    @Override
    public void registerItemRenderer() {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0,
                new ModelResourceLocation(FoodCraft.MODID + ":" + this.getUnlocalizedName().substring(5), "inventory"));
    }
}
