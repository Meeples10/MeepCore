package net.ddns.meepnet.meepcore;

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
                    sender.sendMessage(Messages.reloadAttempt(sender, Main.NAME));
                    sender.sendMessage(Messages.reloadMessage(sender, Main.NAME, Main.loadConfig()));
                } else if(args[0].equalsIgnoreCase("debug")) {
                    sender.sendMessage(Main.getDebug(LocalizationUtils.getLocale(sender)));
                } else if(args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage(Main.getHelp(LocalizationUtils.getLocale(sender)));
                } else if(args[0].equalsIgnoreCase("suite")) {
                    sender.sendMessage(Main.getSuite(LocalizationUtils.getLocale(sender)));
                } else if(args[0].equalsIgnoreCase("locales")) {
                    sender.sendMessage(Main.getLocales(LocalizationUtils.getLocale(sender)));
                } else {
                    return false;
                }
            } else {
                sender.sendMessage(Main.getHelp(LocalizationUtils.getLocale(sender)));
            }
        } else {
            sender.sendMessage(Messages.noPermissionMessage(sender));
        }
        return true;
    }
}