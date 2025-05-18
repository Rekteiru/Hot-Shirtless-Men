package hsm.hotshirtlessmen.mixin;

import hsm.hotshirtlessmen.HSM;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HeldItemRenderer.class)
public class HeldItemRendererMixin {

    @Inject(at = @At("RETURN"), method = "shouldSkipHandAnimationOnSwap", cancellable = true)
    private void stopFlickerOnMending(ItemStack stackFrom, ItemStack stackTo, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) {
            cir.setReturnValue(HSM.compareComponents(stackFrom.getComponents(),stackTo.getComponents()));
        }
    }

}
