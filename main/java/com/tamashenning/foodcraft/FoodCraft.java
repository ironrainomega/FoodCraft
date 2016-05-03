package com.tamashenning.foodcraft;

import com.tamashenning.foodcraft.proxies.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = FoodCraft.MODID, version = FoodCraft.VERSION)
public class FoodCraft {
    public static final String MODID = "FoodCraft";
    public static final String VERSION = "0.0.0.1";

    @Instance
    public static FoodCraft instance = new FoodCraft();

    public static Logger logger;

    @SidedProxy(clientSide = "com.tamashenning.foodcraft.proxies.ClientProxy", serverSide = "com.tamashenning.foodcraft.proxies.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
