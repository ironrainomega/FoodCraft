package com.tamashenning.foodcraft.common.utils;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by TamasH on 5/3/2016.
 * Credits to FireBall1725
 */
public interface IItemRenderer {
    @SideOnly(Side.CLIENT)
    void registerItemRenderer();
}
