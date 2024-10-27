package com.swallows.additionalapi.config;

import net.minecraftforge.common.config.Config;

public class Common {

    @Config.Name("Data")
    @Config.Comment({
            "Data"
    })
    @Config.RequiresMcRestart
    public boolean DATA = true;

}
