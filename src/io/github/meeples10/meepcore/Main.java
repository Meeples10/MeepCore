package io.github.meeples10.meepcore;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {

    protected static final String NAME = "MeepCore";

    private static File df, cfg, msg;
    private static Logger log;
    private static String errorPrefix, noPermissionMessage, reloadMessageAttempt, reloadMessageSuccess,
            reloadMessageFail, usagePrefix, invalidArguments, invalidArgument, invalidArgumentCount, playersOnlyMessage,
            warningPrefix;
    private static ColorScheme sc;

    @Override
    public void onEnable() {
        df = Bukkit.getServer().getPluginManager().getPlugin(NAME).getDataFolder();
        cfg = new File(df, "config.yml");
        msg = new File(df, "messages.yml");
        log = Bukkit.getServer().getPluginManager().getPlugin(NAME).getLogger();
        loadConfig();
        loadMessages();
        this.getCommand("meepcore").setExecutor(new CommandMain());
    }

    public static boolean loadConfig() {
        try {
            if(!df.exists()) {
                df.mkdirs();
            }
            if(!cfg.exists()) {
                log.info("Config not found, creating config.yml");
                Bukkit.getServer().getPluginManager().getPlugin(NAME).saveDefaultConfig();
            } else {
                log.info("Config found, loading config.yml");
            }
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        FileConfiguration c = YamlConfiguration.loadConfiguration(cfg);
        switch(c.getInt("color-scheme")) {
        case 1:
            sc = ColorSchemes.ESSENTIALS;
            break;
        default:
            sc = ColorSchemes.DEFAULT;
            break;
        }
        return true;
    }

    public static boolean loadMessages() {
        try {
            if(!df.exists()) {
                df.mkdirs();
            }
            if(!msg.exists()) {
                log.info("Messages not found, creating messages.yml");
                Bukkit.getServer().getPluginManager().getPlugin(NAME).saveResource("messages.yml", false);
            } else {
                log.info("Messages found, loading messages.yml");
            }
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        FileConfiguration c = YamlConfiguration.loadConfiguration(msg);
        errorPrefix = c.getString("error-prefix");
        noPermissionMessage = c.getString("errors.no-permission");
        reloadMessageAttempt = c.getString("reload.attempt");
        reloadMessageSuccess = c.getString("reload.success");
        reloadMessageFail = c.getString("reload.failure");
        usagePrefix = c.getString("usage-prefix");
        invalidArguments = c.getString("errors.arguments.generic");
        invalidArgument = c.getString("errors.arguments.invalid");
        invalidArgumentCount = c.getString("errors.arguments.invalid-count");
        playersOnlyMessage = c.getString("errors.players-only");
        warningPrefix = c.getString("warning-prefix");
        return true;
    }

    protected static void broadcast(String s, boolean l) {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.sendMessage(s);
        }
        if(l) {
            System.out.println(s);
        }
    }

    protected static String noPermissionMessage() {
        return formatError(noPermissionMessage);
    }

    protected static String formatError(String s) {
        return sc.error() + errorPrefix + sc.errorText() + s;
    }

    protected static String formatWarning(String s) {
        return sc.warning() + warningPrefix + sc.warningText() + s;
    }

    protected static String getReloadMessage(int i) {
        switch(i) {
        case 0:
            return sc.t() + "[" + sc.hl() + "%s" + sc.t() + "] " + reloadMessageAttempt;
        case 1:
            return sc.t() + "[" + sc.hl() + "%s" + sc.t() + "] " + reloadMessageSuccess;
        default:
            return sc.t() + "[" + sc.error() + "%s" + sc.t() + "] " + sc.errorText() + reloadMessageFail;
        }
    }

    protected static String getUsage(String usage) {
        return sc.error() + usagePrefix + sc.errorText() + usage;
    }

    protected static String getInvalidArgumentsMessage() {
        return formatError(invalidArguments);
    }

    protected static String getInvalidArgumentMessage(Object o) {
        return formatError(String.format(invalidArgument, o));
    }

    protected static String getInvalidArgumentCountMessage() {
        return formatError(invalidArgumentCount);
    }

    protected static String getPlayersOnlyMessage() {
        return formatError(playersOnlyMessage);
    }

    protected static ColorScheme getColorScheme() {
        return sc;
    }

    protected static String getHelp() {
        return sc.t() + "" + ChatColor.STRIKETHROUGH + "-----------" + sc.hl() + " MeepCore Help " + sc.t() + ""
                + ChatColor.STRIKETHROUGH + "-------------\n" + sc.hl() + "/meepcore reload" + sc.t()
                + ": Reloads the plugin's configuration files\n" + sc.hl() + "/meepcore debug" + sc.t()
                + ": Shows debug information for the plugin\n" + sc.hl() + "/meepcore help" + sc.t()
                + ": Shows this message\n" + sc.t() + "" + ChatColor.STRIKETHROUGH
                + "-------------------------------------";
    }

    protected static String getDebug() {
        return sc.t() + "" + ChatColor.STRIKETHROUGH + "--------------------" + sc.hl() + " Debug " + sc.t() + ""
                + ChatColor.STRIKETHROUGH + "--------------------\n" + sc.t() + "Color scheme: " + sc.hl()
                + sc.getName() + "\n" + sc.t() + "No permission message: \n> " + noPermissionMessage() + "\n" + sc.t()
                + "Error message: \n> " + formatError("%s") + "\n" + sc.t() + "Warning message: \n> "
                + formatWarning("%s") + "\n" + sc.t() + "Usage message: \n> " + getUsage("%s") + "\n" + sc.t()
                + "Invalid arguments message: \n> " + getInvalidArgumentsMessage() + "\n" + sc.t()
                + "Invalid argument message: \n> " + getInvalidArgumentMessage("%s") + "\n" + sc.t()
                + "Invalid argument count message: \n> " + getInvalidArgumentCountMessage() + "\n" + sc.t()
                + "Players only message: \n> " + getPlayersOnlyMessage() + "\n" + sc.t() + "Reload message 1: \n> "
                + getReloadMessage(0) + "\n" + sc.t() + "Reload message 2: \n> " + getReloadMessage(1) + "\n" + sc.t()
                + "Reload message 3: \n> " + getReloadMessage(2) + "\n" + sc.t() + "" + ChatColor.STRIKETHROUGH
                + "-----------------------------------------------";
    }
}