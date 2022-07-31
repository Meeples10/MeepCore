package io.github.meeples10.meepcore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@SuppressWarnings("deprecation")
public abstract class MCommand extends MeepCommand {

    public MCommand(String usageKey) {
        super(usageKey);
    }

    /**
     * @param sender
     *                   Source of the command
     * @param cmd
     *                   Command which was executed
     * @param label
     *                   Alias of the command which was used
     * @param args
     *                   Passed command arguments
     * @param locale
     *                   The locale of the <tt>sender</tt>
     * @return <tt>true</tt> if a valid command, otherwise <tt>false</tt>
     */
    public abstract boolean run(CommandSender sender, Command cmd, String label, String[] args, String locale);

    @Override
    public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String locale = I18n.getLocale(sender);
        if(!run(sender, cmd, label, args, locale)) {
            sender.sendMessage(I18n.get(locale, getUsageRaw()));
        }
        return true;
    }
}
