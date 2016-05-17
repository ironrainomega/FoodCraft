package com.tamashenning.foodcraft.common.utils;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ironr on 5/15/2016.
 */
public interface IBlockRenderer {
    @SideOnly(Side.CLIENT)
    void registerBlockRenderer();

    @SideOnly(Side.CLIENT)
    void registerBlockItemRenderer();
}
