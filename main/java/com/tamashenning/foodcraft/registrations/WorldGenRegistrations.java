package com.tamashenning.foodcraft.registrations;

import com.tamashenning.foodcraft.common.worldgenerator.FoodCraftWorldGen;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by ironr on 5/16/2016.
 */
public final class WorldGenRegistrations {
    public static void init(){
        GameRegistry.registerWorldGenerator(new FoodCraftWorldGen(), 0);
    }
}
