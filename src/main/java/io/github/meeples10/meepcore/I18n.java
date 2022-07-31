package io.github.meeples10.meepcore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class I18n {
    private static String fallbackLocale = "en_US";
    private static final HashMap<String, HashMap<String, String>> TRANSLATIONS = new HashMap<String, HashMap<String, String>>();

    private static final HashMap<String, ArrayList<String>> PLUGIN_LOCALES = new HashMap<String, ArrayList<String>>();

    public static String getLocale(CommandSender sender) {
        if(sender instanceof Player) {
            return ((Player) sender).getLocale();
        } else {
            return I18n.getFallbackLocale();
        }
    }

    public static String getFallbackLocale() {
        return fallbackLocale;
    }

    public static void setFallbackLocale(String fallbackLocale) {
        I18n.fallbackLocale = fallbackLocale;
    }

    /**
     * @param locale
     *                   The locale to register the translation with
     * @param key
     *                   The translation key
     * @param value
     *                   The string to associate with the key
     */
    private static void registerTranslation(String locale, String key, String value) {
        locale = locale.toLowerCase();
        key = key.toLowerCase();
        if(!TRANSLATIONS.containsKey(locale)) {
            TRANSLATIONS.put(locale, new HashMap<String, String>());
        }
        if(TRANSLATIONS.get(locale).containsKey(key)) {
            Main.log.warning("Duplicate translation key: " + key);
        }
        TRANSLATIONS.get(locale).put(key, value);
    }

    /**
     * @param file
     *                 File containing translation keys and values
     * @throws IOException
     */
    private static void registerTranslations(File file) throws IOException {
        String locale = file.getName().substring(0, file.getName().length() - 11);
        for(String line : FileUtils.read(file)) {
            if(line.startsWith("#") || line.isEmpty()) continue;
            String[] split = line.split("=", 2);
            registerTranslation(locale, split[0], split[1]);
        }
    }

    public static String get(String locale, String key) {
        locale = locale.toLowerCase();
        key = key.toLowerCase();
        if(!TRANSLATIONS.containsKey(locale)) {
            locale = fallbackLocale;
        }
        if(TRANSLATIONS.get(locale).containsKey(key)) {
            return TRANSLATIONS.get(locale).get(key);
        } else {
            return TRANSLATIONS.get(locale).get("missing-translation").replace("{{KEY}}", key);
        }
    }

    /**
     * @deprecated
     * @see #get(String, String)
     */
    public static String getTranslation(String locale, String key) {
        return get(locale, key);
    }

    public static void loadMessages(String pluginName) throws IOException, URISyntaxException {
        JavaPlugin plugin = (JavaPlugin) Bukkit.getPluginManager().getPlugin(pluginName);
        if(!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }
        PLUGIN_LOCALES.put(plugin.getName(), new ArrayList<String>());
        File messageDir = new File(plugin.getDataFolder(), "messages");
        if(!messageDir.exists()) {
            messageDir.mkdirs();
            File file = null;
            try {
                Method getFileMethod = JavaPlugin.class.getDeclaredMethod("getFile");
                getFileMethod.setAccessible(true);
                file = (File) getFileMethod.invoke(plugin);
                getFileMethod.setAccessible(false);
            } catch(Exception e) {
                e.printStackTrace();
                return;
            }
            final JarFile jar = new JarFile(file);
            final Enumeration<JarEntry> entries = jar.entries();
            while(entries.hasMoreElements()) {
                final JarEntry entry = entries.nextElement();
                if(entry.getName().startsWith("messages/")) {
                    if(entry.getName().length() <= 9) {
                        continue;
                    }
                    InputStream is = jar.getInputStream(entry);
                    File out = new File(messageDir, entry.getName().substring(9));
                    out.createNewFile();
                    FileOutputStream fos = new FileOutputStream(out);
                    while(is.available() > 0) {
                        fos.write(is.read());
                    }
                    fos.close();
                    is.close();
                }
            }
            jar.close();
        }
        for(File f : messageDir.listFiles()) {
            I18n.registerTranslations(f);
            PLUGIN_LOCALES.get(plugin.getName()).add(f.getName().substring(0, f.getName().length() - 11));
        }
        if(PLUGIN_LOCALES.get(plugin.getName()).size() > 0) {
            Main.log.info("Loaded " + PLUGIN_LOCALES.get(plugin.getName()).size() + " locale"
                    + (PLUGIN_LOCALES.get(plugin.getName()).size() == 1 ? "" : "s") + " for " + plugin.getName());
        }
    }

    public static ArrayList<String> getLocales(String pluginName) {
        return PLUGIN_LOCALES.get(pluginName);
    }
}
