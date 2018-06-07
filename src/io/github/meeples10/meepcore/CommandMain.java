package io.github.meeples10.meepcore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandMain implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission("meepcore.use")) {
            if(args.length > 0) {
                if(args[0].equalsIgnoreCase("reload")) {
                    sender.sendMessage(Messages.reloadMessage(Main.NAME, 0));
                    if(Main.loadConfig()) {
                        sender.sendMessage(Messages.reloadMessage(Main.NAME, 1));
                    } else {
                        sender.sendMessage(Messages.reloadMessage(Main.NAME, 2));
                    }
                } else if(args[0].equalsIgnoreCase("debug")) {
                    sender.sendMessage(Main.getDebug());
                } else if(args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage(Main.getHelp());
                } else {
                    sender.sendMessage(Main.getUsage("/meepcore help"));
                }
            } else {
                sender.sendMessage(Main.getUsage("/meepcore help"));
            }
        } else {
            sender.sendMessage(Messages.noPermissionMessage());
        }
        return true;
    }
}