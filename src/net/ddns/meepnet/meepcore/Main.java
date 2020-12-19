package net.ddns.meepnet.meepcore;

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
            LocalizationUtils.loadMessages(NAME);
        } catch(Exception e) {
            e.printStackTrace();
        }
        this.getCommand("meepcore").setExecutor(new CommandMain("/meepcore"));
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
        LocalizationUtils.setFallbackLocale(c.getString("fallback-locale").toLowerCase());
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

    protected static String noPermissionMessage(String locale) {
        return formatError(locale, LocalizationUtils.getTranslation(locale, "error.no-permission"));
    }

    protected static String formatError(String locale, String s) {
        return sc.error() + LocalizationUtils.getTranslation(locale, "error.prefix") + sc.errorText() + s;
    }

    protected static String formatWarning(String locale, String s) {
        return sc.warning() + LocalizationUtils.getTranslation(locale, "warning.prefix") + sc.warningText() + s;
    }

    protected static String getReloadMessage(String locale, int i) {
        switch(i) {
        case 0:
            return sc.t() + "[" + sc.hl() + "%s" + sc.t() + "] "
                    + LocalizationUtils.getTranslation(locale, "reload.attempt");
        case 1:
            return sc.t() + "[" + sc.hl() + "%s" + sc.t() + "] "
                    + LocalizationUtils.getTranslation(locale, "reload.success");
        default:
            return sc.t() + "[" + sc.error() + "%s" + sc.t() + "] " + sc.errorText()
                    + LocalizationUtils.getTranslation(locale, "reload.failure");
        }
    }

    protected static String getUsage(String locale, String usage) {
        return sc.error() + LocalizationUtils.getTranslation(locale, "usage.prefix") + sc.errorText() + usage;
    }

    protected static String getInvalidArgumentsMessage(String locale) {
        return formatError(locale, LocalizationUtils.getTranslation(locale, "error.arguments.generic"));
    }

    protected static String getInvalidArgumentMessage(String locale, Object o) {
        return formatError(locale,
                String.format(LocalizationUtils.getTranslation(locale, "error.arguments.invalid"), o));
    }

    protected static String getInvalidArgumentCountMessage(String locale) {
        return formatError(locale, LocalizationUtils.getTranslation(locale, "error.arguments.invalid-count"));
    }

    protected static String getPlayersOnlyMessage(String locale) {
        return formatError(locale, LocalizationUtils.getTranslation(locale, "error.players-only"));
    }

    protected static ColorScheme getColorScheme() {
        return sc;
    }

    protected static String getHelp(String locale) {
        return sc.format("$t" + ChatColor.STRIKETHROUGH + "-----------$hl" + " "
                + LocalizationUtils.getTranslation(locale, "command.meepcore.help.header") + " $t"
                + ChatColor.STRIKETHROUGH + "-------------\n$hl" + "/meepcore reload$t" + ": "
                + LocalizationUtils.getTranslation(locale, "command.meepcore.help.reload") + "\n$hl"
                + "/meepcore debug$t" + ": " + LocalizationUtils.getTranslation(locale, "command.meepcore.help.debug")
                + "\n$hl" + "/meepcore suite$t" + ": "
                + LocalizationUtils.getTranslation(locale, "command.meepcore.help.suite") + "\n$hl"
                + "/meepcore locales$t" + ": "
                + LocalizationUtils.getTranslation(locale, "command.meepcore.help.locales") + "\n$hl"
                + "/meepcore help$t" + ": " + LocalizationUtils.getTranslation(locale, "command.meepcore.help.help")
                + "\n$t" + ChatColor.STRIKETHROUGH + "-------------------------------------");
    }

    protected static String getDebug(String locale) {
        return sc.format("$t" + ChatColor.STRIKETHROUGH + "--------------------$hl" + " "
                + LocalizationUtils.getTranslation(locale, "command.meepcore.debug.header") + " $t"
                + ChatColor.STRIKETHROUGH + "--------------------\n$t"
                + LocalizationUtils.getTranslation(locale, "command.meepcore.debug.color-scheme") + ": $hl"
                + sc.getName() + "\n$t"
                + LocalizationUtils.getTranslation(locale, "command.meepcore.debug.fallback-locale") + ": $hl"
                + LocalizationUtils.getFallbackLocale() + "\n$t" + "No permission message: \n> "
                + noPermissionMessage(locale) + "\n$t" + "Error message: \n> " + formatError(locale, "%s") + "\n$t"
                + "Warning message: \n> " + formatWarning(locale, "%s") + "\n$t" + "Usage message: \n> "
                + getUsage(locale, "%s") + "\n$t" + "Invalid arguments message: \n> "
                + getInvalidArgumentsMessage(locale) + "\n$t" + "Invalid argument message: \n> "
                + getInvalidArgumentMessage(locale, "%s") + "\n$t" + "Invalid argument count message: \n> "
                + getInvalidArgumentCountMessage(locale) + "\n$t" + "Players only message: \n> "
                + getPlayersOnlyMessage(locale) + "\n$t" + "Reload message 1: \n> " + getReloadMessage(locale, 0)
                + "\n$t" + "Reload message 2: \n> " + getReloadMessage(locale, 1) + "\n$t" + "Reload message 3: \n> "
                + getReloadMessage(locale, 2) + "\n$t" + "Missing translation: \n> "
                + LocalizationUtils.getTranslation(locale, "missing-translation") + "\n$t" + ChatColor.STRIKETHROUGH
                + "-----------------------------------------------");
    }

    protected static String getSuite(String locale) {
        String s = "";
        for(Plugin p : Bukkit.getServer().getPluginManager().getPlugins()) {
            if(p.getDescription().getDepend().contains(NAME)) {
                s += "\n$t- " + (p.isEnabled() ? "$hl" : "$e") + p.getName() + " $w[" + p.getDescription().getVersion()
                        + "]";
            }
        }
        return sc.format("$t" + ChatColor.STRIKETHROUGH + "----------------$hl "
                + LocalizationUtils.getTranslation(locale, "command.meepcore.suite.header") + " $t"
                + ChatColor.STRIKETHROUGH + "----------------\n" + s.trim() + "\n$t" + ChatColor.STRIKETHROUGH
                + "-------------------------------------------------");
    }

    protected static String getLocales(String locale) {
        String s = "";
        for(Plugin p : Bukkit.getServer().getPluginManager().getPlugins()) {
            if(p.getName().equals(NAME) || p.getDescription().getDepend().contains(NAME)) {
                s += "\n$t- " + (p.isEnabled() ? "$hl" : "$e") + p.getName() + "$t: ";
                if(LocalizationUtils.getLocales(p.getName()) == null) {
                    s += "$e" + LocalizationUtils.getTranslation(locale, "command.meepcore.locales.none");
                } else {
                    String ls = "";
                    for(String l : LocalizationUtils.getLocales(p.getName())) {
                        ls += ", $w" + (l.equals(locale) ? ChatColor.UNDERLINE : "") + l + "$t";
                    }
                    s += ls.substring(2);
                }
            }
        }
        return sc.format("$t" + ChatColor.STRIKETHROUGH + "----------------$hl "
                + LocalizationUtils.getTranslation(locale, "command.meepcore.locales.header") + " $t"
                + ChatColor.STRIKETHROUGH + "----------------\n" + s.trim() + "\n$t" + ChatColor.STRIKETHROUGH
                + "-------------------------------------------------");
    }
}