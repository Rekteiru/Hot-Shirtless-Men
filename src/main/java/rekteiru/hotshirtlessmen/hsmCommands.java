package rekteiru.hotshirtlessmen;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

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
        if (args[0].equals("bow")) {
            main.BOW_TOGGLE = !main.BOW_TOGGLE;
            if (main.BOW_TOGGLE) {
                main.mc.thePlayer.addChatMessage(new ChatComponentText("BowFix ON"));
            } else {
                main.mc.thePlayer.addChatMessage(new ChatComponentText("BowFix OFF"));
            }
        } else if (args[0].equals("drill")) {
            main.DRILL_TOGGLE = !main.DRILL_TOGGLE;
            if (main.DRILL_TOGGLE) {
                main.mc.thePlayer.addChatMessage(new ChatComponentText("DrillFix ON"));
            } else {
                main.mc.thePlayer.addChatMessage(new ChatComponentText("DrillFix OFF"));
            }
        }

    }

}
