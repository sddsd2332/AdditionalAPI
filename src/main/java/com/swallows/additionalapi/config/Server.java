package com.swallows.additionalapi.config;

import net.minecraftforge.common.config.Config;

public class Server {

    @Config.Name("Authenticate")
    @Config.Comment({
            "如需使用此Mod请先行联系作者（Q：1598773037）否则出现任何问题概不负责！！"
    })
    @Config.RequiresMcRestart
    public String KEY = "Key_";

}
