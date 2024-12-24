package com.swallows.additionalapi.misc;

import com.swallows.additionalapi.crafttweaker.util.SaaBigInteger;
import com.swallows.additionalapi.crafttweaker.util.SaaUUID;
import com.swallows.additionalapi.crafttweaker.world.SaaWorldData;
import crafttweaker.CraftTweakerAPI;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

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

    public static void serverInit(FMLServerStartingEvent event)
    {

    }
}
