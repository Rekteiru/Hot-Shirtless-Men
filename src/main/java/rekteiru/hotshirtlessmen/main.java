package rekteiru.hotshirtlessmen;

import com.mojang.authlib.GameProfile;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
@Mod(modid = "hotshirtlessmen", useMetadata=true)
public class main {

    public static boolean BOW_TOGGLE = true;
    public static boolean DRILL_TOGGLE = true;
    public static GameProfile profile;
    public static boolean Started = false;

    public static Minecraft mc = Minecraft.getMinecraft();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new hsmCommands());
    }

    /* -- too bothered to fix this shit kekw
    @SubscribeEvent
    public void worldTick(TickEvent.WorldTickEvent rw) {
        if (!Started && mc.thePlayer.getGameProfile() != null) {
            Started = true;
            profile = mc.thePlayer.getGameProfile();
        }
    }

    @SubscribeEvent
    public void worldUnload(WorldEvent.Unload ul) {
        Started = false;
    }
    */

}
