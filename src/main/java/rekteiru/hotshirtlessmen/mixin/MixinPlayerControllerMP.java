package rekteiru.hotshirtlessmen.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;

import rekteiru.hotshirtlessmen.Drill;

@Mixin(PlayerControllerMP.class)
public class MixinPlayerControllerMP {

    @Shadow
    private ItemStack currentItemHittingBlock;

    @Shadow
    private BlockPos currentBlock;

    /**
     * @author
     * Mojang
     *
     * @reason
     * Fixes block-breaking progress resetting on inventory updates.
     */
    @Overwrite
    private boolean isHittingPosition(BlockPos pos) {
        return Drill.isHittingPosition(pos, currentItemHittingBlock, currentBlock);
    }
}
