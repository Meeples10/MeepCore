package io.github.meeples10.meepcore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @deprecated Since 1.4.2
 * @see MCommand
 */
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

    /**
     * @deprecated
     * @see MCommand#run(CommandSender, Command, String, String[], String)
     */
    public boolean run(CommandSender sender, Command cmd, String label, String[] args) {
        return true;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!run(sender, cmd, label, args)) {
            sender.sendMessage(getUsage(sender));
        }
        return true;
    }
}
