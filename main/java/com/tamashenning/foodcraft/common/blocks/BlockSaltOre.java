package com.tamashenning.foodcraft.common.blocks;

import com.tamashenning.foodcraft.common.items.FoodCraftItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by ironr on 5/15/2016.
 */
public class BlockSaltOre extends BlockBase {
    public static String unlocalizedName = "salt_ore";

    public BlockSaltOre() {
        super(BlockSaltOre.unlocalizedName);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return FoodCraftItems.SALT_ITEM.item;
    }

    public int quantityDropped(Random random)
    {
        return 4 + random.nextInt(2);
    }

    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
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
