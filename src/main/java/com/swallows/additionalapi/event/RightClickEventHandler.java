package com.swallows.additionalapi.event;

import com.swallows.additionalapi.AdditionalAPI;
import com.swallows.additionalapi.util.WindowsDeviceInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//@Mod.EventBusSubscriber(modid = AdditionalAPI.MOD_ID)
public class RightClickEventHandler {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        EntityPlayer player = event.getEntityPlayer();
        player.sendMessage(new TextComponentString(WindowsDeviceInfo.getCPUId()));
        player.sendMessage(new TextComponentString(WindowsDeviceInfo.getSystemUUID()));
        player.sendMessage(new TextComponentString(WindowsDeviceInfo.getDiskDriveID()));
        player.sendMessage(new TextComponentString(WindowsDeviceInfo.getBIOSID()));
        player.sendMessage(new TextComponentString(WindowsDeviceInfo.getOSID()));
        event.setCanceled(true);
    }
}
