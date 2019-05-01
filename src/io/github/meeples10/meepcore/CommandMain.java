package io.github.meeples10.meepcore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandMain extends MeepCommand {

    public CommandMain(String usage) {
        super(usage);
    }

    @Override
    public boolean run(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission("meepcore.use")) {
            if(args.length > 0) {
                if(args[0].equalsIgnoreCase("reload")) {
                    sender.sendMessage(Messages.reloadMessage(Main.NAME, 0));
                    sender.sendMessage(Messages.reloadMessage(Main.NAME, Main.loadConfig()));
                } else if(args[0].equalsIgnoreCase("debug")) {
                    sender.sendMessage(Main.getDebug());
                } else if(args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage(Main.getHelp());
                } else if(args[0].equalsIgnoreCase("suite")) {
                    sender.sendMessage(Main.getSuite());
                } else {
                    return false;
                }
            } else {
                sender.sendMessage(Main.getHelp());
            }
        } else {
            sender.sendMessage(Messages.noPermissionMessage());
        }
        return true;
    }
}