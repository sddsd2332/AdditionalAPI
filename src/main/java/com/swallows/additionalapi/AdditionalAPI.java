package com.swallows.additionalapi;

import com.swallows.additionalapi.misc.Proxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = Tags.MOD_ID,
        name = Tags.MOD_NAME,
        version = Tags.VERSION,
        dependencies = "required-after:forge@[14.23.5.2847,);" + "required-after:crafttweaker@[4.0.4,);",
        acceptedMinecraftVersions = "[1.12, 1.13)"
)
public class AdditionalAPI {

    public static final String MOD_ID = Tags.MOD_ID;
    public static final String MOD_NAME = Tags.MOD_NAME;

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LOGGER.info("Hello From {}!", Tags.MOD_NAME);
        Proxy.preInit(event);
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        Proxy.Init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        Proxy.postInit(event);
    }

    @Mod.EventHandler
    public void onServerStart(FMLServerStartingEvent event)
    {
        Proxy.onServerStart(event);
    }
}
