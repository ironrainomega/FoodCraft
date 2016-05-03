package com.tamashenning.foodcraft.common.utils;

import com.tamashenning.foodcraft.FoodCraft;
import com.tamashenning.foodcraft.common.utils.models.PlayerStatsModel;

import net.minecraft.entity.player.EntityPlayer;

public class PlayerFoodStats {

    public static PlayerStatsModel init(EntityPlayer player) {
        // TODO: Config option to make it RNG + Server dependent?
        PlayerStatsModel playerStats = new PlayerStatsModel();
        String id = player.getUniqueID().toString();

        playerStats.BitterModifier = minMaxModifier(Integer.parseInt(id.substring(0, 1), 16) * 0.1f);
        playerStats.SweetModifier = minMaxModifier(Integer.parseInt(id.substring(1, 2), 16) * 0.1f);
        playerStats.SourModifier = minMaxModifier(Integer.parseInt(id.substring(2, 3), 16) * 0.1f);
        playerStats.SaltyModifier = minMaxModifier(Integer.parseInt(id.substring(4, 5), 16) * 0.1f);
        playerStats.SavoryModifier = minMaxModifier(Integer.parseInt(id.substring(6, 7), 16) * 0.1f);

        FoodCraft.logger.info("Bitter: " + playerStats.BitterModifier);
        FoodCraft.logger.info("Sweet: " + playerStats.SweetModifier);
        FoodCraft.logger.info("Sour: " + playerStats.SourModifier);
        FoodCraft.logger.info("Salty: " + playerStats.SaltyModifier);
        FoodCraft.logger.info("Savory: " + playerStats.SavoryModifier);

        return playerStats;
    }

    private static float minMaxModifier(float value) {
        if (value < 0.5f)
            return 0.5f;
        if (value > 1.5f)
            return 1.5f;
        return value;
    }
}
