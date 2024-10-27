package com.swallows.additionalapi.misc;

import com.swallows.additionalapi.AdditionalAPI;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class Proxy {

    public static void preInit(FMLPreInitializationEvent event)
    {
        if(event.getSide().isServer()) {
            ConfigManager.sync(AdditionalAPI.MOD_ID, Config.Type.INSTANCE);
        }
    }

    public static void Init(FMLInitializationEvent event)
    {

    }

    public static void postInit(FMLPostInitializationEvent event)
    {

    }

    public static void serverInit(FMLServerStartingEvent event)
    {

    }
}
