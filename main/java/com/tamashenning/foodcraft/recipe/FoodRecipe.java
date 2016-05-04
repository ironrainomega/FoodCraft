package com.tamashenning.foodcraft.recipe;

import java.util.List;

import com.tamashenning.foodcraft.common.items.ItemsFoodBase;
import com.tamashenning.foodcraft.common.utils.models.ModifierModel;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class FoodRecipe extends ShapelessOreRecipe {

    private final ItemStack recipeOutput;

    public float bitter;
    public float sweet;
    public float sour;
    public float salty;
    public float savory;
    public int heal;
    public float saturation;

    public Potion potionId;
    public float potionProbability;
    public int potionLength;

    public FoodRecipe(ItemStack recipeOutput, Object... recipe) {
        super(recipeOutput, recipe);
        this.recipeOutput = output;
    }

    public FoodRecipe(ItemStack output, List<ItemStack> inputList) {
        super(output, inputList);
        this.recipeOutput = output;
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        return super.matches(inv, worldIn);
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack newItem = this.recipeOutput.copy();
        NBTTagCompound nbt;
        float prevbitter = 0, prevsweet = 0, prevsour = 0, prevsalty = 0, prevsavory = 0, prevsaturation = 0;
        int prevheal = 0;

        for (int i = 0; i < inv.getHeight(); ++i) {
            for (int j = 0; j < inv.getWidth(); ++j) {
                ItemStack itemstack = inv.getStackInRowAndColumn(j, i);

                if (itemstack != null) {

                    if (itemstack.getItem() instanceof ItemsFoodBase) {
                        if (itemstack.hasTagCompound()) {

                            nbt = itemstack.getTagCompound();
                            prevbitter += minManGetValueFloat(nbt.getFloat("Bitter"), bitter);
                            prevsweet += minManGetValueFloat(nbt.getFloat("Sweet"), sweet);
                            prevsour += minManGetValueFloat(nbt.getFloat("Sour"), sour);
                            prevsalty += minManGetValueFloat(nbt.getFloat("Salty"), salty);
                            prevsavory += minManGetValueFloat(nbt.getFloat("Savory"), savory);
                            prevheal += minManGetValueInt(nbt.getInteger("Heal"), heal);
                            prevsaturation += minManGetValueFloat(nbt.getFloat("Saturation"), saturation, 20f);

                            ((ItemsFoodBase) itemstack.getItem()).setPotionEffect(new PotionEffect(potionId, potionLength), potionProbability);
                        }
                    }
                }
            }
        }

        if (newItem.getItem() instanceof ItemsFoodBase) {
            ItemsFoodBase item = (ItemsFoodBase) newItem.getItem();
            item.setValuesToNbt(newItem, prevbitter, prevsweet, prevsour, prevsalty, prevsavory,
                    prevheal, prevsaturation);
        }

        return newItem;
    }

    private float minManGetValueFloat(float x, float y) {
        return minManGetValueFloat(x, y, 5);
    }

    private float minManGetValueFloat(float x, float y, float max) {
        float newVal = x + y;

        if (newVal < 0)
            return 1f;

        if (newVal > max)
            return 5;

        return newVal;
    }

    private int minManGetValueInt(int x, int y) {
        int newVal = x + y;

        if (newVal < 0)
            return 1;

        if (newVal > 20)
            return 20;

        return newVal;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return super.getRecipeOutput();
    }

    public static FoodRecipe createRecipe(ItemStack output, ModifierModel model, Object... recipeComponents) {
        FoodRecipe result = new FoodRecipe(output, recipeComponents);
        result.bitter = model.BitterModifier;
        result.sweet = model.SweetModifier;
        result.sour = model.SourModifier;
        result.salty = model.SaltyModifier;
        result.savory = model.SavoryModifier;
        result.heal = model.HealModifier;
        result.saturation = model.SaturationModifier;
        result.potionId = model.PotionId;
        result.potionProbability = model.PotionPorbability;
        result.potionLength = model.PotionLength;
        return result;
    }

}
