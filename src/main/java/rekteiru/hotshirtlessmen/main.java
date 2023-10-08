package rekteiru.hotshirtlessmen;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft;

@Mod(modid = "hotshirtlessmen", useMetadata=true)
public class main {

    public static Minecraft mc = Minecraft.getMinecraft();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("hot shirtless men in the area");
    }
}
