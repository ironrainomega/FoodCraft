package com.tamashenning.foodcraft.common.utils.models;

import net.minecraft.potion.Potion;

public class ModifierModel {
	public float BitterModifier = 0f;
	public float SweetModifier = 0f;
	public float SourModifier = 0f;
	public float SaltyModifier = 0f;
	public float SavoryModifier = 0f;

	public int HealModifier = 0;
	public float SaturationModifier = 0f;
	
	public Potion PotionId = null;
	public float PotionPorbability = 0f;
	public int PotionLength = 0;
	
	public Object item;
}
