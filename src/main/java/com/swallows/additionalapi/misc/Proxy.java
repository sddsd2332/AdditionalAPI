package com.swallows.additionalapi.misc;

import com.swallows.additionalapi.command.CommandCreativeRSA;
import com.swallows.additionalapi.config.AdditionalAPIConfig;
import crafttweaker.CraftTweakerAPI;
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
    public static void serverStarting(FMLServerStartingEvent event)
    {
        if(AdditionalAPIConfig.ConfigRSA.RSA) {
            event.registerServerCommand(new CommandCreativeRSA());
        }
    }
}
