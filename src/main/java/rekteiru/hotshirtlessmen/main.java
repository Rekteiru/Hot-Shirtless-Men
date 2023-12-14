package rekteiru.hotshirtlessmen;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

@Mod(modid = "hotshirtlessmen", useMetadata=true)
public class main {
    public static final String modid = "hotshirtlessmen";
    public static boolean BOW_TOGGLE = true;
    public static boolean DRILL_TOGGLE = true;
    public static boolean HOTSHIRTLESSMEN_TOGGLE = false;
    public static boolean HOTFEETLESSMEN_TOGGLE = false;
    public static Minecraft mc = Minecraft.getMinecraft();
    public static BufferedImage gigachad = null;
    public static BufferedImage hotfeet = null;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new hsmCommands());
        boolean bool = true;
        int tries = 0;
        while (bool) {
            try {
                gigachad = ImageIO.read(new URL("https://s.namemc.com/i/2d0d2dd073beef70.png"))
                        .getSubimage(HotShirtlessMenFeature.imgArray[11][0],HotShirtlessMenFeature.imgArray[11][1],HotShirtlessMenFeature.imgArray[11][2],HotShirtlessMenFeature.imgArray[11][3]);

                BufferedImage temp = new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);
                for (int x = 12; x < HotShirtlessMenFeature.imgArray.length; x++) {
                    temp.getGraphics().drawImage(ImageIO.read(new URL("https://s.namemc.com/i/2d0d2dd073beef70.png"))
                            .getSubimage(HotShirtlessMenFeature.imgArray[x][0],HotShirtlessMenFeature.imgArray[x][1],HotShirtlessMenFeature.imgArray[x][2],HotShirtlessMenFeature.imgArray[x][3])
                            ,HotShirtlessMenFeature.imgArray[x][0],HotShirtlessMenFeature.imgArray[x][1],null);
                }
                hotfeet = temp;

                if (gigachad != null && hotfeet != null) {
                    bool = false;
                }
            } catch (Exception e) {
                tries++;
                System.out.println("Failed to load a texture, "+tries+" trie(s). Exception: "+e);
                if (tries > 300) {
                    System.out.println("Too many attempts to load textures. Skipping textures.");
                    bool = false;
                }
            }
        }
    }

}