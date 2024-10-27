package com.swallows.additionalapi.util;

import com.swallows.additionalapi.data.ArchiveData;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class getData {

    public static ArchiveData getArchiveData(String name) {
        World world = DimensionManager.getWorld(0);
        ArchiveData archivedata = null;
        if (world.getMapStorage() != null) {
            archivedata = (ArchiveData) world.getMapStorage().getOrLoadData(ArchiveData.class, name + "_Archive");
            if(archivedata == null)
            {
                archivedata = new ArchiveData(name + "_Archive");
                world.getMapStorage().setData(name + "_Archive", archivedata);
            }
        }
        return archivedata;
    }

    public static ArchiveData getWorldData(String name, int DIM_ID) {
        World world = DimensionManager.getWorld(DIM_ID);
        return getWorldData(name, world);
    }

    public static ArchiveData getWorldData(String name, World world) {
        ArchiveData archivedata = (ArchiveData) world.getPerWorldStorage().getOrLoadData(ArchiveData.class, name + "_World");
        if(archivedata == null)
        {
            archivedata = new ArchiveData(name + "_World");
            world.getPerWorldStorage().setData(name + "_World", archivedata);
        }
        return archivedata;
    }
}
