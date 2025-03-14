package com.swallows.additionalapi.config;

import net.minecraftforge.common.config.Config;

public class ConfigIC2 {

    @Config.Name("ElectricFurnaceExperience")
    @Config.Comment({
            "如果为true，则关闭IC2电炉经验掉落"
    })
    @Config.RequiresMcRestart
    public boolean ElectricFurnaceExperience = true;

}
