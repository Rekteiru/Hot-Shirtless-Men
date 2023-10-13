package rekteiru.hotshirtlessmen;

import com.mojang.authlib.GameProfile;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Bow {
    public static boolean BowFix(ItemStack itemInUse, ItemStack itemstack, GameProfile profileIn) {
        //todo: add a toggle here
        return itemInUse != itemstack &&
                itemstack.getItem() == itemInUse.getItem() &&
                itemstack.getItem() == Item.getItemById(261) &&
                profileIn.getId() == main.mc.thePlayer.getUniqueID();
    }
}
