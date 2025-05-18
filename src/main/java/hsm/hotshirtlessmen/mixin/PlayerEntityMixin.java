package hsm.hotshirtlessmen.mixin;

import com.mojang.authlib.GameProfile;
import hsm.hotshirtlessmen.HSM;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Shadow
    private ItemStack selectedItem;

    @Final
    @Shadow
    private GameProfile gameProfile;

    @Inject(at = @At("HEAD"), method = "resetLastAttackedTicks")
    private void attackCdReset(CallbackInfo ci) {
        try {
            if (MinecraftClient.getInstance().player.getGameProfile() == gameProfile) {
                ItemStack stack = MinecraftClient.getInstance().player.getMainHandStack();
                if (selectedItem != stack) {
                    if (HSM.compareComponents(selectedItem.getComponents(),stack.getComponents())) {
                        selectedItem = stack;
                    }
                }
            }
        } catch (Exception e) {
            HSM.LOGGER.error("stupid NPE i dont care to fix {}", e.toString());
        }
    }

}
