package com.tamashenning.foodcraft.common.blocks;

import com.tamashenning.foodcraft.FoodCraft;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * Created by ironr on 5/30/2016.
 */
public class BlockOven extends BlockBase {
    public static String unlocalizedName = "oven_block";

    public BlockOven() {
        super(BlockOven.unlocalizedName);
        this.setTickRandomly(true);
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }

    public int quantityDroppedWithBonus(int fortune, Random random) {
        return 1;
    }

    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this);
    }


    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        BlockPos[] positionToCheck = new BlockPos[] {
                pos.down(),
                pos.down().add(-1,0,0), pos.down().add(-1,0,-1), pos.down().add(0,0,-1),
                pos.down().add(1,0,0), pos.down().add(1,0,1), pos.down().add(0,0,1),
                pos.down().add(-1,0,1), pos.down().add(1,0,-1),

                pos.down().down(),
                pos.down().down().add(-1,0,0) , pos.down().down().add(-1,0,-1), pos.down().down().add(0, 0,-1),
                pos.down().down().add(1,0,0) , pos.down().down().add(1,0, 1), pos.down().down().add(0,0,1),
                pos.down().down().add(-1,0,1), pos.down().down().add(1,0,-1)
        };

        Block[][] assertBlocks = new Block[][] {
                { Blocks.FIRE, Blocks.AIR },
                { Blocks.BRICK_STAIRS, Blocks.AIR },{ Blocks.BRICK_STAIRS }, { Blocks.BRICK_STAIRS, Blocks.AIR },
                { Blocks.BRICK_STAIRS, Blocks.AIR },{ Blocks.BRICK_STAIRS }, { Blocks.BRICK_STAIRS, Blocks.AIR },
                { Blocks.BRICK_STAIRS },{ Blocks.BRICK_STAIRS },

                { Blocks.NETHERRACK },
                { Blocks.BRICK_BLOCK }, { Blocks.BRICK_BLOCK }, { Blocks.BRICK_BLOCK },
                { Blocks.BRICK_BLOCK }, { Blocks.BRICK_BLOCK }, { Blocks.BRICK_BLOCK },
                { Blocks.BRICK_BLOCK }, { Blocks.BRICK_BLOCK }
        };

        int i = 0;

        for (BlockPos p : positionToCheck) {

            Block blockInWorld = worldIn.getBlockState(p).getBlock();
            FoodCraft.logger.info("[BlockOven]: "+blockInWorld.getUnlocalizedName()+ " found at "+p.toString());
            boolean found = false;

            for (Block b : assertBlocks[i]) {
                if (blockInWorld == b)
                {
                    // FoodCraft.logger.info("[BlockOven]: "+blockInWorld.getUnlocalizedName()+ " found at "+p.toString() + " expecting " + b.getUnlocalizedName());
                    found = true;
                    break;
                }
            }

            if (!found)
                return false;

            i++;
        }
        return true;
    }


    public void neighborChanged(IBlockState world, World worldIn, BlockPos pos, Block blockIn) {
        if (!this.canPlaceBlockAt(worldIn, pos)) {
            if (worldIn.isRemote)
                return;

            worldIn.destroyBlock(pos, true);
            worldIn.setBlockToAir(pos);
        }
    }


    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        // If fire below is still going...
        if(worldIn.getBlockState(pos.down()).getBlock() == Blocks.FIRE) {
            for (int i = 0; i < 3; ++i) {
                double d0 = (double) pos.getX() + rand.nextDouble();
                double d1 = (double) pos.getY() + rand.nextDouble() * 0.5D + 1D;
                double d2 = (double) pos.getZ() + rand.nextDouble();
                worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

    }
}
