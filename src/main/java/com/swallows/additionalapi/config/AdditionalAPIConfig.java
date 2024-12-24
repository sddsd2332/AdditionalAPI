package com.swallows.additionalapi.config;

import com.cleanroommc.configanytime.ConfigAnytime;
import com.swallows.additionalapi.AdditionalAPI;
import net.minecraftforge.common.config.Config;

@Config(modid = AdditionalAPI.MOD_ID, name = AdditionalAPI.MOD_NAME)
public class AdditionalAPIConfig {

    @Config.Name("Common")
    public static Common COMMON = new Common();

    @Config.Name("Server")
    public static Server SERVER = new Server();

//    static {
//        ConfigAnytime.register(AdditionalAPIConfig.class);
//    }
}
