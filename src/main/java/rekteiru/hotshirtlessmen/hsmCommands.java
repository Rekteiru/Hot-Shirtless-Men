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
        switch (args[0]) {
            case "bow":
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
                break;
            case "drill":
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
                break;
            case "shirtless":
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
                break;
            case "barefoot":
                if (length > 1 && (args[1].equals("on") || args[1].equals("off"))) {
                    main.HOTBAREFOOTMEN_TOGGLE = args[1].equals("on");
                } else {
                    main.HOTBAREFOOTMEN_TOGGLE = !main.HOTBAREFOOTMEN_TOGGLE;
                }
                if (main.HOTBAREFOOTMEN_TOGGLE) {
                    main.mc.thePlayer.addChatMessage(new ChatComponentText("HotBarefootMen ON"));
                } else {
                    main.mc.thePlayer.addChatMessage(new ChatComponentText("HotBarefootMen OFF"));
                }
                break;
            case "darkness":
                if (length > 1) {
                    try {
                        int i = parseInt(args[1].replace("%", ""));
                        main.darkness = 100 - Math.min(Math.max(i, 0), 100);
                        main.mc.thePlayer.addChatMessage(new ChatComponentText("Darkness value set to " + main.darkness + "%"));
                    } catch (Exception e) {
                        main.mc.thePlayer.addChatMessage(new ChatComponentText("Incorrect usage, use /hsm darkness [percentage]"));
                    }
                }
                break;
        }

    }
}
