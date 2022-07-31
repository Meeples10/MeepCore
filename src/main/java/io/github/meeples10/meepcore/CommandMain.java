package io.github.meeples10.meepcore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandMain extends MCommand {

    public CommandMain(String usage) {
        super(usage);
    }

    @Override
    public boolean run(CommandSender sender, Command cmd, String label, String[] args, String locale) {
        if(sender.hasPermission("meepcore.use")) {
            if(args.length > 0) {
                if(args[0].equalsIgnoreCase("reload")) {
                    sender.sendMessage(Messages.reloadAttempt(locale, Main.NAME));
                    sender.sendMessage(Messages.reloadMessage(locale, Main.NAME, Main.loadConfig()));
                } else if(args[0].equalsIgnoreCase("debug")) {
                    sender.sendMessage(Main.getDebug(locale));
                } else if(args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage(Main.getHelp(locale));
                } else if(args[0].equalsIgnoreCase("suite")) {
                    sender.sendMessage(Main.getSuite(locale));
                } else if(args[0].equalsIgnoreCase("locales")) {
                    sender.sendMessage(Main.getLocales(locale));
                } else {
                    return false;
                }
            } else {
                sender.sendMessage(Main.getHelp(locale));
            }
        } else {
            sender.sendMessage(Messages.noPermissionMessage(locale));
        }
        return true;
    }
}
