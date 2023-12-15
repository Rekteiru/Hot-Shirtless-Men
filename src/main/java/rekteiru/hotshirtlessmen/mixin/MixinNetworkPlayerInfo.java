package rekteiru.hotshirtlessmen.mixin;


import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rekteiru.hotshirtlessmen.HotMenFeature;
import rekteiru.hotshirtlessmen.main;

@Mixin(NetworkPlayerInfo.class)
public class MixinNetworkPlayerInfo {
    @Shadow
    private ResourceLocation locationSkin;

    @Inject(method = "getLocationSkin", at = @At("HEAD"), cancellable = true)
    private void hotmen(CallbackInfoReturnable<ResourceLocation> cir) {

        if (locationSkin != null && (main.HOTBAREFOOTMEN_TOGGLE || main.HOTSHIRTLESSMEN_TOGGLE)) {
            ResourceLocation output = HotMenFeature.getLocation(locationSkin);
            if (output != locationSkin) {
                cir.setReturnValue(output);
            }
        }

    }

}
