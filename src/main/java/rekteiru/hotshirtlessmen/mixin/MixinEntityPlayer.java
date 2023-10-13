package rekteiru.hotshirtlessmen.mixin;

import net.minecraft.entity.player.InventoryPlayer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import com.mojang.authlib.GameProfile;

import rekteiru.hotshirtlessmen.Bow;

@Mixin(EntityPlayer.class)
public abstract class MixinEntityPlayer {

    @Shadow
    private ItemStack itemInUse;

    @Shadow
    public InventoryPlayer inventory;

    @Final
    @Shadow
    private GameProfile gameProfile;

    @Inject(method = "onUpdate", at = @At("HEAD"))
    protected void bowFixStuff(CallbackInfo ci){
        if (itemInUse != null) {

            ItemStack itemstack = inventory.getCurrentItem();

            if (Bow.BowFix(itemInUse, itemstack, gameProfile)) {
                itemInUse = itemstack;
            }
        }
    }
}
