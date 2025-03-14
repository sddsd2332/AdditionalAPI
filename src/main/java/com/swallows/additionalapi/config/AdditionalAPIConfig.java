package com.swallows.additionalapi.config;

import com.swallows.additionalapi.AdditionalAPI;
import net.minecraftforge.common.config.Config;

@Config(modid = AdditionalAPI.MOD_ID, name = AdditionalAPI.MOD_NAME)
public class AdditionalAPIConfig {

    @Config.Name("RSA")
    public static ConfigRSA ConfigRSA = new ConfigRSA();
    @Config.Name("Botania")
    public static ConfigBotania ConfigBOTANIA = new ConfigBotania();
    @Config.Name("TConevo")
    public static ConfigTConevo ConfigTCONEVO = new ConfigTConevo();
    @Config.Name("ic2")
    public static ConfigIC2 configIC2 = new ConfigIC2();
}
