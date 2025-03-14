package com.swallows.additionalapi.mixin.tconevo;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import xyz.phanta.tconevo.constant.NameConst;
import xyz.phanta.tconevo.trait.avaritia.TraitOmnipotence;

@Mixin(value = TraitOmnipotence.class, remap = false)
public abstract class MixinTraitOmnipotence extends AbstractTrait {

    public MixinTraitOmnipotence() {
        super(NameConst.TRAIT_OMNIPOTENCE, 0xf6d785);
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        if (target.world.isRemote || !wasHit
                || (player instanceof EntityPlayer && ((EntityPlayer)player).getCooledAttackStrength(0.5F) < 0.95F)) {
            return;
        }
        float undealtDmg = Math.max(target.getMaxHealth() / 2F - damageDealt, 0F);
        if (undealtDmg > 0F) {
            if(target.getHealth() - undealtDmg <= 0F){
                target.setHealth(0);
                target.onDeath(new EntityDamageSource("infinity", player));
            }
            else {
                target.setHealth(target.getHealth() - undealtDmg);
            }
        }
    }
}
