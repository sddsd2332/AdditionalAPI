package com.swallows.additionalapi.misc;

import crafttweaker.CraftTweakerAPI;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;

public class Proxy {

    public static void preInit(FMLPreInitializationEvent event)
    {
        CraftTweakerAPI.tweaker.loadScript(false, "additionalapi");
    }

    public static void Init(FMLInitializationEvent event)
    {

    }

    public static void postInit(FMLPostInitializationEvent event)
    {

    }
    public static void onServerStart(FMLServerStartingEvent event)
    {

    }
}
