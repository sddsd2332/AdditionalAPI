package com.swallows.additionalapi.crafttweaker.world;

import com.swallows.additionalapi.data.ArchiveData;
import com.swallows.additionalapi.util.getData;
import crafttweaker.api.data.IData;
import crafttweaker.mc1120.data.NBTConverter;
import net.minecraft.nbt.NBTTagCompound;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.additionalapi.SaWorldData")
@SuppressWarnings("unused")
public class SaaWorldData {

    @ZenMethod
    public static void setArchiveData (String name, String key, IData iData) {
        ArchiveData archivedata = getData.getArchiveData(name);
        archivedata.setArchiveData(key, (NBTTagCompound) NBTConverter.from(iData));
    }

    @ZenMethod
    public static void addArchiveData (String name, String key, IData iData) {
        ArchiveData archivedata = getData.getArchiveData(name);
        archivedata.addArchiveData(key, (NBTTagCompound) NBTConverter.from(iData));
    }

    @ZenMethod
    public static void upArchiveData (String name, String key, IData iData) {
        ArchiveData archivedata = getData.getArchiveData(name);
        archivedata.upArchiveData(key, (NBTTagCompound) NBTConverter.from(iData));
    }

    @ZenMethod
    public  static IData getArchiveData (String name, String key) {
        ArchiveData archivedata = getData.getArchiveData(name);
        NBTTagCompound data = new NBTTagCompound();
        if(archivedata.isArchiveData(key))
            data = archivedata.getArchiveData(key);
        return NBTConverter.from(data, false);
    }

    @ZenMethod
    public static void removeArchiveData(String name, String key) {
        ArchiveData archivedata = getData.getArchiveData(name);
        if(archivedata.isArchiveData(key))
            archivedata.removeArchiveData(key);
    }

    @ZenMethod
    public  static boolean isArchiveData (String name, String key) {
        ArchiveData archivedata = getData.getArchiveData(name);
        return archivedata.isArchiveData(key);
    }
}
