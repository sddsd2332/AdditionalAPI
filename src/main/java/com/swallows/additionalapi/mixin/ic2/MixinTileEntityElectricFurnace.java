package com.swallows.additionalapi.mixin.ic2;

import ic2.api.network.INetworkClientTileEntityEventListener;
import ic2.api.recipe.MachineRecipeResult;
import ic2.core.block.machine.tileentity.TileEntityElectricFurnace;
import ic2.core.block.machine.tileentity.TileEntityStandardMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Collection;

@Mixin(TileEntityElectricFurnace.class)
public abstract class MixinTileEntityElectricFurnace extends TileEntityStandardMachine<ItemStack, ItemStack, ItemStack> implements INetworkClientTileEntityEventListener {


    public MixinTileEntityElectricFurnace(int energyPerTick, int length, int outputSlots) {
        super(energyPerTick, length, outputSlots);
    }


    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        return nbt;
    }

    @Override
    public void operateOnce(MachineRecipeResult<ItemStack, ItemStack, ItemStack> result, Collection<ItemStack> processResult) {
        super.operateOnce(result, processResult);
    }

    @Override
    public void onNetworkEvent(EntityPlayer player, int event) {
        assert event != 0 || !this.getWorld().isRemote;
    }
}
