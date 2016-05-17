package com.tamashenning.foodcraft.common.blocks;

import com.tamashenning.foodcraft.common.items.FoodCraftItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by ironr on 5/16/2016.
 */
public class BlockSaltBlock extends BlockBase {
    public static String unlocalizedName = "salt_block";

    public BlockSaltBlock() {
        super(BlockSaltBlock.unlocalizedName);
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }

    public int quantityDroppedWithBonus(int fortune, Random random) {
        return 1;
    }

    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this);
    }

}
