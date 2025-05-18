package hsm.hotshirtlessmen.mixin;

import hsm.hotshirtlessmen.HSM;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {

    @Shadow
    private ItemStack selectedStack;

    @Final
    @Shadow
    private MinecraftClient client;

    @Shadow
    private BlockPos currentBreakingPos;

    @Inject(at = @At("RETURN"), method = "isCurrentlyBreaking", cancellable = true)
    private void itemStackCompare(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue() && pos.equals(currentBreakingPos)) {
            assert client.player != null;
            ItemStack hand = client.player.getMainHandStack();
            if (HSM.compareComponents(hand.getComponents(),selectedStack.getComponents())) {
                selectedStack = hand;
                cir.setReturnValue(true);
            } else {
                cir.setReturnValue(false);
            }
        }
    }

}
