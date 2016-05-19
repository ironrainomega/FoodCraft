package com.tamashenning.foodcraft.common.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ironr on 5/16/2016.
 */
public class BlockCheese extends BlockBase {
    public static String unlocalizedName = "cheese_block";

    private AxisAlignedBB boundingBox;

    public BlockCheese() {
        super(BlockCheese.unlocalizedName, Material.CAKE, 1.0f, 2.5f);
        this.setCreativeTab(CreativeTabs.MATERIALS);

        boundingBox = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.5D, 0.9375D);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return boundingBox;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getCollisionBoundingBox(IBlockState worldIn, World pos, BlockPos state)
    {
        return worldIn.getSelectedBoundingBox(pos, state);
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
}
