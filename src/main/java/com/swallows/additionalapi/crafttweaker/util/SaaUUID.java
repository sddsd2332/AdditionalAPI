package com.swallows.additionalapi.crafttweaker.util;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@ZenClass("mods.additionalapi.SaUUID")
@SuppressWarnings("unused")
public class SaaUUID {

    @ZenMethod
    public static String getRandomUUID () {
        return UUID.randomUUID().toString();
    }

    @ZenMethod
    public static String getOfflineUUIDByPlayerName (String PlayerName) {
        return UUID.nameUUIDFromBytes(("OfflinePlayer:" + PlayerName).getBytes(StandardCharsets.UTF_8)).toString();
    }

    @ZenMethod
    public static String getPlayerNameByUUID(String uuid) {
        MinecraftServer server = DimensionManager.getWorld(0).getMinecraftServer();
        if (server == null) {
            return null;
        }
        GameProfile profile = server.getPlayerProfileCache().getProfileByUUID(UUID.fromString(uuid));
        return profile != null ? profile.getName() : null;
    }

    @ZenMethod
    public static String getUUIDByPlayerName(String PlayerName) {
        MinecraftServer server = DimensionManager.getWorld(0).getMinecraftServer();
        if (server == null) {
            return null;
        }
        GameProfile profile = server.getPlayerProfileCache().getGameProfileForUsername(PlayerName);
        return profile != null ? profile.getId().toString() : null;
    }
}
