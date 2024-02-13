package rekteiru.hotshirtlessmen;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;

public class utils {

    public static java.lang.String getLore(ItemStack item) {
        try {
            StringBuilder lore = new StringBuilder();
            NBTTagCompound nbt = item.getSubCompound("display",false);
            if (nbt == null) {
               // main.mc.thePlayer.addChatMessage(new ChatComponentText("null nbt on getLore"));
            }
            NBTTagList nbtlist = nbt.getTagList("Lore",10);
            if (nbtlist == null) {
               // main.mc.thePlayer.addChatMessage(new ChatComponentText("null nbtlist on getLore"));
            }
            for (int i=0; i < nbtlist.tagCount(); i++) {
                lore.append(nbtlist.getStringTagAt(i));
            }
            return lore.toString();
        } catch (Exception e) {
           // main.mc.thePlayer.addChatMessage(new ChatComponentText("Exception on utils getLore"));
            return "";
        }
    }

    public static String getUUID(ItemStack item) {
        try {
            NBTTagCompound nbt = item.getSubCompound("ExtraAttributes",false);
            return nbt.getString("uuid");
        } catch (Exception e) {
            return "";
        }
    }

    public static String getName(ItemStack item) {
        try {
            NBTTagCompound nbt = item.getSubCompound("display",false);
            return nbt.getString("Name");
        } catch (Exception e) {
            return "";
        }
    }

    public static String getSkyblockID(ItemStack item) {
        try {
            NBTTagCompound nbt = item.getSubCompound("ExtraAttributes",false);
            return nbt.getString("id");
        } catch (Exception e) {
            return "";
        }
    }

}
