package rekteiru.hotshirtlessmen;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

@Mod(modid = "hotshirtlessmen", useMetadata=true)
public class main {
    public static final String modid = "hotshirtlessmen";
    public static boolean BOW_TOGGLE = true;
    public static boolean DRILL_TOGGLE = true;
    public static boolean HOTSHIRTLESSMEN_TOGGLE = false;
    public static boolean HOTBAREFOOTMEN_TOGGLE = false;
    public static Minecraft mc = Minecraft.getMinecraft();
    public static BufferedImage gigachad = null;
    public static BufferedImage hotfeet = null;
    public static int darkness = 25;
    public static String basePath = "";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        basePath = System.getProperty("user.dir").replace("\\","/");
        ClientCommandHandler.instance.registerCommand(new hsmCommands());

        try {
            clearFolder(new File(basePath+"/assets/"+modid+"/PlayerSkins/"));
        } catch (Exception e) {
            System.out.println("Unable to clear PlayerSkins folder");
        }

        boolean bool = true;
        int tries = 0;
        while (bool) {
            try {

                gigachad = ImageIO.read(new File(basePath+"/assets/"+modid+"/gigachad.png"));

                hotfeet = ImageIO.read(new File(basePath+"/assets/"+modid+"/hotfeet.png"));

                if (gigachad != null && hotfeet != null) {
                    gigachad = (BufferedImage) HotMenFeature.desaturate(gigachad);
                    hotfeet = (BufferedImage) HotMenFeature.desaturate(hotfeet);
                    bool = false;
                }
            } catch (Exception e) {
                tries++;
                System.out.println("Failed to load a texture, "+tries+" trie(s). Exception: "+e);
                if (tries > 69) {
                    System.out.println("Too many attempts to load textures. Skipping textures.");
                    bool = false;
                }
            }
        }
    }

    public static void clearFolder(File folder) {
        File[] files = folder.listFiles();
        if(files!=null) {
            for(File f: files) {
                f.delete();
            }
        }
    }

}