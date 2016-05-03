package com.tamashenning.foodcraft.common.items;

import java.util.List;

import com.tamashenning.foodcraft.FoodCraft;
import com.tamashenning.foodcraft.common.utils.PlayerFoodStats;
import com.tamashenning.foodcraft.common.utils.models.PlayerStatsModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public abstract class ItemsFoodBase extends ItemFood {

    public float FoodBitterModifier = 0f;
    public float FoodSweetModifier = 0f;
    public float FoodSourModifier = 0f;
    public float FoodSaltyModifier = 0f;
    public float FoodSavoryModifier = 0f;
    public float FoodSaturationAmount = 0f;

    public int FallbackHealAmount = 0;

    public ItemsFoodBase() {
        super(0, 0f, false);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onFoodEaten(stack, world, player);
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        super.onCreated(itemStack, world, entityPlayer);
        saveNbt(itemStack, entityPlayer);
    }

    // Players can pass food from one to the other and the NBT values have to be recomputed.
    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        ActionResult<ItemStack> result = super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
        saveNbt(itemStackIn, playerIn);
        return result;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        super.addInformation(itemStack, player, list, par4);

        if (!itemStack.hasTagCompound()) {
            saveNbt(itemStack, player);
        }

        NBTTagCompound nbt = itemStack.getTagCompound();

        list.add("Bitter: " + nbt.getFloat("Bitter"));
        list.add("Sweet: " + nbt.getFloat("Sweet"));
        list.add("Sour: " + nbt.getFloat("Sour"));
        list.add("Salty: " + nbt.getFloat("Salty"));
        list.add("Savory: " + nbt.getFloat("Savory"));
    }

    @Override
    public int getHealAmount(ItemStack itemStack) {
        int actualHealAmount = this.FallbackHealAmount;
        if (itemStack.hasTagCompound()) {
            actualHealAmount = itemStack.getTagCompound().getInteger("Heal");
        }

        FoodCraft.logger.info("Actual heal: " + actualHealAmount);

        return actualHealAmount;
    }

    @Override
    public float getSaturationModifier(ItemStack itemStack) {
        float actualSaturation = this.FoodSaturationAmount;
        if (itemStack.hasTagCompound()) {
            actualSaturation = itemStack.getTagCompound().getFloat("Saturation");
        }

        FoodCraft.logger.info("Actual saturation: " + actualSaturation);

        return actualSaturation;
    }

    public void saveNbt(ItemStack itemStack, EntityPlayer entityPlayer) {
        PlayerStatsModel playerStats = PlayerFoodStats.init(entityPlayer);
        float bitter, sweet, sour, salty, savory, saturation;

        if (itemStack.hasTagCompound()) {
            NBTTagCompound nbt = itemStack.getTagCompound();
            bitter = nbt.getFloat("Bitter");
            sweet = nbt.getFloat("Sweet");
            sour = nbt.getFloat("Sour");
            salty = nbt.getFloat("Salty");
            savory = nbt.getFloat("Savory");
            saturation = nbt.getFloat("Saturation");
        } else {
            bitter = this.FoodBitterModifier;
            sweet = this.FoodSweetModifier;
            sour = this.FoodSourModifier;
            salty = this.FoodSaltyModifier;
            savory = this.FoodSavoryModifier;
            saturation = this.FoodSaturationAmount;
        }

        int healAmount = (int) (bitter * playerStats.BitterModifier + sweet * playerStats.SweetModifier
                + sour * playerStats.SourModifier + salty * playerStats.SaltyModifier
                + savory * playerStats.SavoryModifier);

        FoodCraft.logger
                .info(SoupItem.unlocalizedName + " Heal: " + healAmount + " Saturation: " + saturation);

        this.setValuesToNbt(itemStack, bitter, sweet, sour, salty, savory, healAmount, saturation);
    }

    public ItemsFoodBase setValuesToNbt(ItemStack itemStack, float bitter, float sweet, float sour, float salty,
                                        float savory, int heal, float saturation) {

        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setFloat("Bitter", bitter);
        nbt.setFloat("Sweet", sweet);
        nbt.setFloat("Sour", sour);
        nbt.setFloat("Salty", salty);
        nbt.setFloat("Savory", savory);
        nbt.setInteger("Heal", heal);
        nbt.setFloat("Saturation", saturation);
        itemStack.setTagCompound(nbt);

        return this;
    }

    public ItemsFoodBase setValuesToNbt(ItemStack itemStack) {
        return this.setValuesToNbt(itemStack, FoodBitterModifier, FoodSweetModifier, FoodSourModifier,
                FoodSaltyModifier, FoodSavoryModifier, FallbackHealAmount, FoodSaturationAmount);
    }
}
