package rekteiru.hotshirtlessmen.mixin;

import net.minecraft.client.renderer.ImageBufferDownload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import rekteiru.hotshirtlessmen.HotShirtlessMenFeature;
import rekteiru.hotshirtlessmen.main;

import java.awt.image.BufferedImage;

@Mixin(ImageBufferDownload.class)
public class MixinImageBufferDownload {

    @ModifyVariable(method = "parseUserSkin", at = @At("HEAD"), argsOnly = true)
    private BufferedImage hotshirtlessmen(BufferedImage image) {
        if (main.HOTSHIRTLESSMEN_TOGGLE || main.HOTFEETLESSMEN_TOGGLE) {
            return HotShirtlessMenFeature.hotshirtlessmen(image);
        } else return image;
    }

}