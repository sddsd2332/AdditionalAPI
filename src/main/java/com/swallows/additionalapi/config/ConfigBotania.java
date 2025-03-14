package com.swallows.additionalapi.config;

import net.minecraftforge.common.config.Config;

public class ConfigBotania {

    @Config.Name("RuneRefunded")
    @Config.Comment({
            "如果为'true'则关闭符文祭坛返还配方中的符文(即消耗符文)",
            "必须添加'植物魔法'Mod"
    })
    @Config.RequiresMcRestart
    public boolean RuneRefunded = true;

}
