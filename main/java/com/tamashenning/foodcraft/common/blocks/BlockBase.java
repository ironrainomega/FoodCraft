package com.tamashenning.foodcraft.common.blocks;

import com.tamashenning.foodcraft.FoodCraft;
import com.tamashenning.foodcraft.common.utils.IBlockRenderer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ironr on 5/15/2016.
 */
public class BlockBase extends Block implements IBlockRenderer {

    public BlockBase(String unlocalizedName, Material material, float hardness, float resistance) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    public BlockBase(String unlocalizedName, float hardness, float resistance) {
        this(unlocalizedName, Material.rock, hardness, resistance);
    }

    public BlockBase(String unlocalizedName) {
        this(unlocalizedName, 2.0f, 10.0f);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockItemRenderer() {
        Item item = Item.getItemFromBlock(this);

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
                new ModelResourceLocation(FoodCraft.MODID + ":" + this.getUnlocalizedName().substring(5), "inventory"));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockRenderer() {
        final String unlocedname = this.getUnlocalizedName();
        // Credit to FireBall1725
        ModelLoader.setCustomStateMapper(this, new DefaultStateMapper() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                FoodCraft.logger.info("Registering: "+FoodCraft.MODID + ":" + unlocedname.substring(5));
                return new ModelResourceLocation(FoodCraft.MODID + ":" + unlocedname.substring(5), getPropertyString(state.getProperties()));
            }
        });
    }
}

