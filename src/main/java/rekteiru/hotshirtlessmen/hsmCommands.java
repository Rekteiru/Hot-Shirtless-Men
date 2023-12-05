package rekteiru.hotshirtlessmen;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.util.Objects;

public class hsmCommands extends CommandBase {

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
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
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
        }

    }
}
