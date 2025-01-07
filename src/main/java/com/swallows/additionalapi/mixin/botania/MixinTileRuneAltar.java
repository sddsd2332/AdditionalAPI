package com.swallows.additionalapi.mixin.botania;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeRuneAltar;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.block.tile.TileRuneAltar;
import vazkii.botania.common.block.tile.TileSimpleInventory;
import vazkii.botania.common.item.ModItems;

import java.util.ArrayList;
import java.util.List;

@Mixin(value = TileRuneAltar.class)
public abstract class MixinTileRuneAltar extends TileSimpleInventory {

    @Shadow
    int mana;
    @Shadow
    RecipeRuneAltar currentRecipe;
    @Shadow
    public int manaToGet;
    @Shadow
    public void saveLastRecipe() {}
    @Shadow
    public void recieveMana(int mana) {}

    @Unique
    public static List<ItemStack> itemStacks = new ArrayList<>();

    @Unique
    public void setRuneItems() {
        for(int i = 0; i < 16; i++) {
            itemStacks.add(new ItemStack(ModItems.rune, 1, i));
        }
    }


    @Overwrite
    public void onWanded(EntityPlayer player, ItemStack wand) {
        setRuneItems();
        if (!this.world.isRemote) {
            RecipeRuneAltar recipe = null;
            if (this.currentRecipe != null) {
                recipe = this.currentRecipe;
            } else {
                for(RecipeRuneAltar recipe_ : BotaniaAPI.runeAltarRecipes) {
                    if (recipe_.matches(this.itemHandler)) {
                        recipe = recipe_;
                        break;
                    }
                }
            }
            if (this.manaToGet > 0 && this.mana >= this.manaToGet) {
                List<EntityItem> items = this.world.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(this.pos, this.pos.add(1, 1, 1)));
                EntityItem livingrock = null;
                for(EntityItem item : items) {
                    if (!item.isDead && !item.getItem().isEmpty() && item.getItem().getItem() == Item.getItemFromBlock(ModBlocks.livingrock)) {
                        livingrock = item;
                        break;
                    }
                }
                if (livingrock != null) {
                    int mana = recipe.getManaUsage();
                    this.recieveMana(-mana);
                    ItemStack output = recipe.getOutput().copy();
                    EntityItem outputItem = new EntityItem(this.world, (double)this.pos.getX() + (double)0.5F, (double)this.pos.getY() + (double)1.5F, (double)this.pos.getZ() + (double)0.5F, output);
                    this.world.spawnEntity(outputItem);
                    this.currentRecipe = null;
                    this.world.addBlockEvent(this.getPos(), ModBlocks.runeAltar, 1, 60);
                    this.world.addBlockEvent(this.getPos(), ModBlocks.runeAltar, 2, 0);
                    this.saveLastRecipe();
                    for(int i = 0; i < this.getSizeInventory(); i++) {
                        ItemStack stack = this.itemHandler.getStackInSlot(i);
                        if (!stack.isEmpty()) {
                            if ((player == null || !player.capabilities.isCreativeMode)) {
                                EntityItem outputRune = new EntityItem(this.world, (double)this.getPos().getX() + (double)0.5F, (double)this.getPos().getY() + (double)1.5F, (double)this.getPos().getZ() + (double)0.5F, stack.copy());
                                this.world.spawnEntity(outputRune);
                            }
                            this.itemHandler.setStackInSlot(i, ItemStack.EMPTY);
                        }
                    }
                    livingrock.getItem().shrink(1);
                }
            }
        }
    }

    @Unique
    public static void addItem(ItemStack stack) {
        itemStacks.add(stack);
    }

    @Unique
    public static void removeItem(ItemStack stack) {
        itemStacks.remove(stack);
    }

}
