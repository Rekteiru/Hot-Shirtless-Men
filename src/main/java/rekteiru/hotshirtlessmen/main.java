package rekteiru.hotshirtlessmen;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft;

@Mod(modid = "hotshirtlessmen", useMetadata=true)
public class main {

    public static boolean BOW_TOGGLE = false;
    public static boolean DRILL_TOGGLE = false;

    public static Minecraft mc = Minecraft.getMinecraft();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new hsmCommands());
    }

}
