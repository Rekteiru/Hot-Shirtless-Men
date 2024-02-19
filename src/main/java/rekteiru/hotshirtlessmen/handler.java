package rekteiru.hotshirtlessmen;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class handler {

    @SubscribeEvent
    public void ForceQuiverArrow(TickEvent.PlayerTickEvent event) {
        if (main.QUIVER_TOGGLE && event.phase == TickEvent.Phase.START) {
            ItemStack item = main.mc.thePlayer.getHeldItem();
            if (item != main.previousItem) {
                if (item == null) {
                    main.has9thSlotQuiver = false;
                } else if (item.getItem() == Item.getItemById(261)) { // bow item
                    String id = utils.getSkyblockID(item);
                    // main.mc.thePlayer.addChatMessage(new ChatComponentText("bow: "+id));
                    if (
                            !id.contains("TERMINATOR") &&
                            !id.contains("SHORTBOW") &&
                            !id.contains("MACHINE_GUN_BOW") &&
                            !id.contains("ITEM_SPIRIT_BOW")
                    ) {
                        if (!main.has9thSlotQuiver) {
                            main.mc.thePlayer.inventory.setInventorySlotContents(8,new ItemStack(Item.getItemById(262),64)); // 9th slot arrows
                            main.has9thSlotQuiver = true;
                        }
                    } else if (main.mc.thePlayer.inventory.getStackInSlot(8).getItem() == Item.getItemById(262)) { // if you're swapping to a shortbow from a bow, change 9th slot from arrow to nether star
                        main.mc.thePlayer.inventory.setInventorySlotContents(8,new ItemStack(Item.getItemById(399),1)); // 9th slot nether star
                        main.has9thSlotQuiver = false;
                    }
                } else main.has9thSlotQuiver = false;
            }
            main.previousItem = item;
        }
    }

    @SubscribeEvent
    public void QuiverCheck(ClientChatReceivedEvent e) {
        if (e.type == 0 && main.hasEnabledQuiver) {
            String msg = e.message.getUnformattedText();
            if ((msg.startsWith("You don't have any more arrows left in your Quiver!") || msg.startsWith("Cleared your quiver!")) && main.QUIVER_TOGGLE) {
                main.mc.thePlayer.addChatMessage(new ChatComponentText("§b§lQuiverFix §rtoggled §4§lOFF §rfrom the lack of quiver arrows"));
                main.QUIVER_TOGGLE = false;
            }
            if ((msg.startsWith("You filled your quiver with") || msg.startsWith("Jax forged")) && !main.QUIVER_TOGGLE) {
                main.mc.thePlayer.addChatMessage(new ChatComponentText("§b§lQuiverFix §rtoggled back §2§lON §rby refilling quiver arrows"));
                main.QUIVER_TOGGLE = true;
            }
        }
    }

}
