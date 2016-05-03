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

        for (int i = 0; i < inv.getHeight(); ++i) {
            for (int j = 0; j < inv.getWidth(); ++j) {
                ItemStack itemstack = inv.getStackInRowAndColumn(j, i);

                if (itemstack != null) {

                    if (itemstack.getItem() instanceof ItemsFoodBase) {
                        if (itemstack.hasTagCompound()) {

                            NBTTagCompound nbt = itemstack.getTagCompound();
                            float prevbitter = minManGetValueFloat(nbt.getFloat("Bitter"), bitter);
                            float prevsweet = minManGetValueFloat(nbt.getFloat("Sweet"), sweet);
                            float prevsour = minManGetValueFloat(nbt.getFloat("Sour"), sour);
                            float prevsalty = minManGetValueFloat(nbt.getFloat("Salty"), salty);
                            float prevsavory = minManGetValueFloat(nbt.getFloat("Savory"), savory);
                            int prevheal = minManGetValueInt(nbt.getInteger("Heal"), heal);
                            float prevsaturation = minManGetValueFloat(nbt.getFloat("Saturation"), saturation, 20f);

                            ItemsFoodBase item = (ItemsFoodBase) itemstack.getItem();
                            item.setValuesToNbt(newItem, prevbitter, prevsweet, prevsour, prevsalty, prevsavory,
                                    prevheal, prevsaturation);

                            item.setPotionEffect(new PotionEffect(potionId, potionLength), potionProbability);
                        }
                    }
                }
            }
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
