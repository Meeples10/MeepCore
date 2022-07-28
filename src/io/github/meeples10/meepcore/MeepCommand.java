package io.github.meeples10.meepcore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class MeepCommand implements CommandExecutor {
    private String usageKey;

    public MeepCommand(String usageKey) {
        this.usageKey = usageKey;
    }

    /**
     * @deprecated Since 1.4.0
     */
    public String getUsage() {
        return Messages.usage(usageKey);
    }

    public String getUsage(CommandSender sender) {
        return Messages.usage(sender, Messages.translate(sender, usageKey));
    }

    public String getUsageRaw() {
        return usageKey;
    }

    public abstract boolean run(CommandSender sender, Command cmd, String label, String[] args);

    @Override
    public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!run(sender, cmd, label, args)) {
            sender.sendMessage(getUsage(sender));
        }
        return true;
    }
}