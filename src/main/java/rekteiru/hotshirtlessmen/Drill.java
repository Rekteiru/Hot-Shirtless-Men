package rekteiru.hotshirtlessmen;

import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.item.Item;

public class Drill {
    public static boolean isHittingPosition(BlockPos pos, ItemStack currentItemHittingBlock, BlockPos currentBlock)
    {
        ItemStack itemstack = main.mc.thePlayer.getHeldItem();
        boolean flag = currentItemHittingBlock == null && itemstack == null;

        if (currentItemHittingBlock != null && itemstack != null)
        {
            if (main.DRILL_TOGGLE &&
                    itemstack.getItem() == currentItemHittingBlock.getItem() &&
                    (
                    itemstack.getItem() == Item.getItemById(409) ||  // prismarine shard
                    itemstack.getItem() == Item.getItemById(397) ||  // player head
                    itemstack.getItem() == Item.getItemById(270) ||  // wooden pickaxe
                    itemstack.getItem() == Item.getItemById(274) ||  // stone pickaxe
                    itemstack.getItem() == Item.getItemById(257) ||  // iron pickaxe
                    itemstack.getItem() == Item.getItemById(285) ||  // golden pickaxe
                    itemstack.getItem() == Item.getItemById(278)     // diamond pickaxe
                    )) {
                return pos.equals(currentBlock);
            }

            flag = itemstack.getItem() == currentItemHittingBlock.getItem() && ItemStack.areItemStackTagsEqual(itemstack, currentItemHittingBlock) && (itemstack.isItemStackDamageable() || itemstack.getMetadata() == currentItemHittingBlock.getMetadata());
        }

        return pos.equals(currentBlock) && flag;
    }
}
