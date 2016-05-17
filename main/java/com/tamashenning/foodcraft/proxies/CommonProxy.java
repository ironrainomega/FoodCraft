package com.tamashenning.foodcraft.proxies;

import com.tamashenning.foodcraft.FoodCraft;
import com.tamashenning.foodcraft.common.utils.CraftingFoodModifiers;
import com.tamashenning.foodcraft.registrations.CraftingRegistrations;
import com.tamashenning.foodcraft.registrations.ItemRegistrations;
import com.tamashenning.foodcraft.registrations.OreDictionaryRegistrations;
import com.tamashenning.foodcraft.registrations.WorldGenRegistrations;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        ItemRegistrations.init();
        Configuration config = new Configuration(e.getSuggestedConfigurationFile());
        config.load();

        FoodCraft.config = config;

        config.save();
    }

    public void init(FMLInitializationEvent e) {
        OreDictionaryRegistrations.init();
        CraftingRegistrations.init();
        WorldGenRegistrations.init();
        FoodCraft.config.save();
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
