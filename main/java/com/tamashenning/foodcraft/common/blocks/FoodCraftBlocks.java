package com.tamashenning.foodcraft.common.blocks;

import com.tamashenning.foodcraft.common.utils.IBlockRenderer;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by ironr on 5/15/2016.
 */
public enum FoodCraftBlocks {

    SALTBLOCK(new BlockSalt());

    public final Block block;

    FoodCraftBlocks(Block block) {
        this.block = block;
    }

    public static void registerItems() {
        for (FoodCraftBlocks i : FoodCraftBlocks.values()) {
            i.register();
        }
    }

    public static void registerRenders() {
        for (FoodCraftBlocks i : FoodCraftBlocks.values()) {
            i.registerRender();
        }
    }

    public void register() {
        GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
    }

    public void registerRender() {
        if (block instanceof IBlockRenderer && FMLCommonHandler.instance().getEffectiveSide().isClient()) {
            ((IBlockRenderer) block).registerBlockItemRenderer();
            ((IBlockRenderer) block).registerBlockRenderer();
        }
    }
}
