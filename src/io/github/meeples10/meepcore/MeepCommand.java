package io.github.meeples10.meepcore;

import org.bukkit.command.CommandExecutor;

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
}