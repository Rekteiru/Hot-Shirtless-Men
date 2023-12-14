package rekteiru.hotshirtlessmen;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class hsmCommands extends CommandBase implements ICommand {

    @Override
    public String getCommandName() {
        return "hsm";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "Use /hsm [drill|bow] to toggle drill/bow functionality.";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        int length = args.length;
        if (args[0].equals("bow")) {
            if (length > 1 && (args[1].equals("on") || args[1].equals("off"))) {
                main.BOW_TOGGLE = args[1].equals("on");
            } else {
                main.BOW_TOGGLE = !main.BOW_TOGGLE;
            }
            if (main.BOW_TOGGLE) {
                main.mc.thePlayer.addChatMessage(new ChatComponentText("BowFix ON"));
            } else {
                main.mc.thePlayer.addChatMessage(new ChatComponentText("BowFix OFF"));
            }
        } else if (args[0].equals("drill")) {
            if (length > 1 && (args[1].equals("on") || args[1].equals("off"))) {
                main.DRILL_TOGGLE = args[1].equals("on");
            } else {
                main.DRILL_TOGGLE = !main.DRILL_TOGGLE;
            }
            if (main.DRILL_TOGGLE) {
                main.mc.thePlayer.addChatMessage(new ChatComponentText("DrillFix ON"));
            } else {
                main.mc.thePlayer.addChatMessage(new ChatComponentText("DrillFix OFF"));
            }
        } else if (args[0].equals("shirtless")) {
            if (length > 1 && (args[1].equals("on") || args[1].equals("off"))) {
                main.HOTSHIRTLESSMEN_TOGGLE = args[1].equals("on");
            } else {
                main.HOTSHIRTLESSMEN_TOGGLE = !main.HOTSHIRTLESSMEN_TOGGLE;
            }
            if (main.HOTSHIRTLESSMEN_TOGGLE) {
                main.mc.thePlayer.addChatMessage(new ChatComponentText("HotShirtlessMen ON"));
            } else {
                main.mc.thePlayer.addChatMessage(new ChatComponentText("HotShirtlessMen OFF"));
            }
        } else if (args[0].equals("feetless")) {
            if (length > 1 && (args[1].equals("on") || args[1].equals("off"))) {
                main.HOTFEETLESSMEN_TOGGLE = args[1].equals("on");
            } else {
                main.HOTFEETLESSMEN_TOGGLE = !main.HOTFEETLESSMEN_TOGGLE;
            }
            if (main.HOTFEETLESSMEN_TOGGLE) {
                main.mc.thePlayer.addChatMessage(new ChatComponentText("HotFeetlessMen ON"));
            } else {
                main.mc.thePlayer.addChatMessage(new ChatComponentText("HotFeetlessMen OFF"));
            }
        }

    }
}
