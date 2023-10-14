package rekteiru.hotshirtlessmen;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Bow {
    public static boolean BowFix(ItemStack itemInUse, ItemStack itemstack) {
        return main.BOW_TOGGLE &&
                itemInUse != itemstack &&
                itemstack.getItem() == itemInUse.getItem() &&
                itemstack.getItem() == Item.getItemById(261);
    }
}
