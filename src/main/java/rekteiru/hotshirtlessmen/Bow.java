package rekteiru.hotshirtlessmen;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Bow {
    public static boolean BowFix(ItemStack itemInUse, ItemStack itemstack) throws NullPointerException {
        String id = utils.getSkyblockID(itemstack);
        return main.BOW_TOGGLE &&
                itemInUse != itemstack &&
                itemstack.getItem() == itemInUse.getItem() &&
                itemstack.getItem() == Item.getItemById(261) &&
                !id.contains("TERMINATOR") &&
                !id.contains("SHORTBOW") &&
                !id.contains("MACHINE_GUN_BOW") &&
                !id.contains("ITEM_SPIRIT_BOW");
    }

}
