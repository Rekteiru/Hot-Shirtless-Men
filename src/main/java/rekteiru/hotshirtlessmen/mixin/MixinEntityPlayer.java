package rekteiru.hotshirtlessmen.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.Minecraft;

import rekteiru.hotshirtlessmen.main;

@Mixin(EntityPlayer.class)
public class MixinEntityPlayer {

    Minecraft mine = main.mc;

    @Shadow
    private ItemStack itemInUse;

    @Inject(method = "onUpdate", at = @At("HEAD"))
    protected void bowFixStuff(CallbackInfo ci){
        if (itemInUse != null) {

            ItemStack itemstack = mine.thePlayer.inventory.getCurrentItem();

            if (itemstack != itemInUse) {
                if (itemstack.getItem() == Item.getItemById(261) && itemstack.getItem() == itemInUse.getItem()) {
                    itemInUse = itemstack;
                }
            }
        }
    }
}
