package com.swallows.additionalapi.data;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.storage.WorldSavedData;

public class ArchiveData extends WorldSavedData {

    public String Name;
    private  NBTTagCompound nbt = new NBTTagCompound();

    public ArchiveData(String name) {
        super(name);
        this.Name = name;
    }

    public ArchiveData(String name, NBTTagCompound nbt) {
        super(name);
        this.Name = name;
        this.nbt = nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
            this.nbt = nbt;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        return this.nbt;
    }

    public void setArchiveData(String key, NBTTagCompound data) {
        this.nbt.setTag(key, data);
        markDirty();
    }

    public void addArchiveData(String key, NBTTagCompound data) {
        for (String s : data.getKeySet()) {
            if(!isArchiveData(key))
                this.nbt.getCompoundTag(key).setTag(s, data.getTag(s));
        }
        markDirty();
    }

    public void upArchiveData(String key, NBTTagCompound data) {
        for (String s : data.getKeySet())
            this.nbt.getCompoundTag(key).setTag(s, data.getTag(s));
        markDirty();
    }

    public void removeArchiveData(String key) {
        if(isArchiveData(key))
            this.nbt.removeTag(key);
        markDirty();
    }

    public NBTTagCompound getArchiveData(String key) {
        if(isArchiveData(key))
            return this.nbt.getCompoundTag(key);
        return null;
    }

    public boolean isArchiveData(String key) {
        return this.nbt.hasKey(key);
    }
}
