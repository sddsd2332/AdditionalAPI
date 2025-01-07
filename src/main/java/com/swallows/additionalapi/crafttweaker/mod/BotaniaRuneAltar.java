package com.swallows.additionalapi.crafttweaker.mod;

import com.swallows.additionalapi.mixin.botania.MixinTileRuneAltar;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraftforge.fml.common.Mod;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.additionalapi.BotaniaRuneAltar")
@Mod.EventBusSubscriber(modid = "botania")
@SuppressWarnings("unused")
public class BotaniaRuneAltar {

    @ZenMethod
    public static void RuneAltarNotConsume(IItemStack iStack) {
        MixinTileRuneAltar.addItem(CraftTweakerMC.getItemStack(iStack));
    }

    @ZenMethod
    public static void RuneAltarConsume(IItemStack iStack) {
        MixinTileRuneAltar.removeItem(CraftTweakerMC.getItemStack(iStack));
    }
}
