package com.swallows.additionalapi.config;

import net.minecraftforge.common.config.Config;

public class ConfigRSA {

    @Config.Name("RSA")
    @Config.Comment({
            "如果为'true'则注册RSA公私钥对生成命令"
    })
    @Config.RequiresMcRestart
    public boolean RSA = false;

//    @Config.Name("PrivateKey")
//    @Config.Comment({
//            "请在此填写私钥"
//    })
//    @Config.RequiresMcRestart
//    public String PrivateKey = "null";

}
