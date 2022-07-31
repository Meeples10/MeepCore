package io.github.meeples10.meepcore;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    protected static final String NAME = "MeepCore";

    private static File df, cfg;
    protected static Logger log;
    private static ColorScheme sc;

    @Override
    public void onEnable() {
        df = Bukkit.getServer().getPluginManager().getPlugin(NAME).getDataFolder();
        cfg = new File(df, "config.yml");
        log = Bukkit.getServer().getPluginManager().getPlugin(NAME).getLogger();
        loadConfig();
        try {
            I18n.loadMessages(NAME);
        } catch(Exception e) {
            e.printStackTrace();
        }
        this.getCommand("meepcore").setExecutor(new CommandMain("command.meepcore.usage"));
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
        case 2:
            sc = ColorSchemes.MUTED;
            break;
        default:
            sc = ColorSchemes.DEFAULT;
            break;
        }
        I18n.setFallbackLocale(c.getString("fallback-locale").toLowerCase());
        return true;
    }

    /**
     * @deprecated Since 1.2.3
     */
    @Deprecated
    protected static void broadcast(String s, boolean l) {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.sendMessage(s);
        }
        if(l) {
            log.info(s);
        }
    }

    protected static void broadcast(String s) {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.sendMessage(s);
        }
    }

    protected static void broadcast(String s, String permission) {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            if(p.hasPermission(permission)) p.sendMessage(s);
        }
    }

    protected static void broadcastTranslated(String key) {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.sendMessage(I18n.get(I18n.getLocale(p), key));
        }
    }

    protected static void broadcastTranslated(String key, String permission) {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            if(p.hasPermission(permission)) p.sendMessage(I18n.get(I18n.getLocale(p), key));
        }
    }

    protected static String noPermissionMessage(String locale) {
        return formatError(locale, I18n.get(locale, "error.no-permission"));
    }

    protected static String formatError(String locale, String s) {
        return sc.error() + I18n.get(locale, "error.prefix") + sc.errorText() + s;
    }

    protected static String formatWarning(String locale, String s) {
        return sc.warning() + I18n.get(locale, "warning.prefix") + sc.warningText() + s;
    }

    protected static String getReloadMessage(String locale, int i) {
        switch(i) {
        case 0:
            return sc.t() + "[" + sc.hl() + "%s" + sc.t() + "] " + I18n.get(locale, "reload.attempt");
        case 1:
            return sc.t() + "[" + sc.hl() + "%s" + sc.t() + "] " + I18n.get(locale, "reload.success");
        default:
            return sc.t() + "[" + sc.error() + "%s" + sc.t() + "] " + sc.errorText()
                    + I18n.get(locale, "reload.failure");
        }
    }

    protected static String getUsage(String locale, String usage) {
        return sc.error() + I18n.get(locale, "usage.prefix") + sc.errorText() + usage;
    }

    protected static String getInvalidArgumentsMessage(String locale) {
        return formatError(locale, I18n.get(locale, "error.arguments.generic"));
    }

    protected static String getInvalidArgumentMessage(String locale, Object o) {
        return formatError(locale, String.format(I18n.get(locale, "error.arguments.invalid"), o));
    }

    protected static String getInvalidArgumentCountMessage(String locale) {
        return formatError(locale, I18n.get(locale, "error.arguments.invalid-count"));
    }

    protected static String getPlayersOnlyMessage(String locale) {
        return formatError(locale, I18n.get(locale, "error.players-only"));
    }

    protected static ColorScheme getColorScheme() {
        return sc;
    }

    protected static String getHelp(String locale) {
        return Messages.section(I18n.get(locale, "command.meepcore.help.header"),
                "/meepcore reload$t" + ": " + I18n.get(locale, "command.meepcore.help.reload") + "\n$hl"
                        + "/meepcore debug$t" + ": " + I18n.get(locale, "command.meepcore.help.debug") + "\n$hl"
                        + "/meepcore suite$t" + ": " + I18n.get(locale, "command.meepcore.help.suite") + "\n$hl"
                        + "/meepcore locales$t" + ": " + I18n.get(locale, "command.meepcore.help.locales") + "\n$hl"
                        + "/meepcore help$t" + ": " + I18n.get(locale, "command.meepcore.help.help"));
    }

    protected static String getDebug(String locale) {
        return Messages.section(I18n.get(locale, "command.meepcore.debug.header"),
                I18n.get(locale, "command.meepcore.debug.color-scheme") + ": $hl" + sc.getName() + "\n$t"
                        + I18n.get(locale, "command.meepcore.debug.fallback-locale") + ": $hl"
                        + I18n.getFallbackLocale() + "\n$t" + "No permission message: \n> "
                        + noPermissionMessage(locale) + "\n$t" + "Error message: \n> " + formatError(locale, "%s")
                        + "\n$t" + "Warning message: \n> " + formatWarning(locale, "%s") + "\n$t"
                        + "Usage message: \n> " + getUsage(locale, "%s") + "\n$t" + "Invalid arguments message: \n> "
                        + getInvalidArgumentsMessage(locale) + "\n$t" + "Invalid argument message: \n> "
                        + getInvalidArgumentMessage(locale, "%s") + "\n$t" + "Invalid argument count message: \n> "
                        + getInvalidArgumentCountMessage(locale) + "\n$t" + "Players only message: \n> "
                        + getPlayersOnlyMessage(locale) + "\n$t" + "Reload message 1: \n> "
                        + getReloadMessage(locale, 0) + "\n$t" + "Reload message 2: \n> " + getReloadMessage(locale, 1)
                        + "\n$t" + "Reload message 3: \n> " + getReloadMessage(locale, 2) + "\n$t"
                        + "Missing translation: \n> " + I18n.get(locale, "missing-translation"));
    }

    protected static String getSuite(String locale) {
        String s = "";
        for(Plugin p : Bukkit.getServer().getPluginManager().getPlugins()) {
            if(p.getDescription().getDepend().contains(NAME)) {
                s += "\n$t- " + (p.isEnabled() ? "$hl" : "$e") + p.getName() + " $w[" + p.getDescription().getVersion()
                        + "]";
            }
        }
        return Messages.section(I18n.get(locale, "command.meepcore.suite.header"), s.trim());
    }

    protected static String getLocales(String locale) {
        String s = "";
        for(Plugin p : Bukkit.getServer().getPluginManager().getPlugins()) {
            if(p.getName().equals(NAME) || p.getDescription().getDepend().contains(NAME)) {
                s += "\n$t- " + (p.isEnabled() ? "$hl" : "$e") + p.getName() + "$t: ";
                if(I18n.getLocales(p.getName()) == null) {
                    s += "$e" + I18n.get(locale, "command.meepcore.locales.none");
                } else {
                    String ls = "";
                    for(String l : I18n.getLocales(p.getName())) {
                        ls += ", $w" + (l.equals(locale) ? ChatColor.UNDERLINE : "") + l + "$t";
                    }
                    s += ls.substring(2);
                }
            }
        }
        return Messages.section(I18n.get(locale, "command.meepcore.locales.header"), s.trim());
    }
}
