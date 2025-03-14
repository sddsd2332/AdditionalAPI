package com.swallows.additionalapi.config;

import net.minecraftforge.common.config.Config;

public class ConfigTConevo {

    @Config.Name("OmnipotenceItemDrops")
    @Config.Comment({
            "全知全能(Omnipotence)词条击杀无掉落物修复",
            "必须同时添加'匠魂进化'与'无尽贪婪'Mod"
    })
    @Config.RequiresMcRestart
    public boolean OmnipotenceItemDrops = true;

}
