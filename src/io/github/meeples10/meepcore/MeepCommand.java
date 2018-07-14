package io.github.meeples10.meepcore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class MeepCommand implements CommandExecutor {
    private String usage;

    public MeepCommand(String usage) {
        this.usage = usage;
    }

    public String getUsage() {
        return Messages.usage(usage);
    }

    public String getUsageRaw() {
        return usage;
    }

    public abstract boolean run(CommandSender sender, Command cmd, String label, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!run(sender, cmd, label, args)) {
            sender.sendMessage(getUsage());
        }
        return true;
    }
}