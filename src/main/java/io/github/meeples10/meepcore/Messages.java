package io.github.meeples10.meepcore;

import java.util.Arrays;

import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public final class Messages {

    /**
     * @return The plugin's current color scheme
     */
    public static ColorScheme getColorScheme() {
        return Main.getColorScheme();
    }

    /**
     * @deprecated Since 1.4.0
     */
    public static String noPermissionMessage() {
        return Main.noPermissionMessage(I18n.getFallbackLocale());
    }

    /**
     * @deprecated Since 1.4.0
     */
    public static String formatError(String s) {
        return Main.formatError(I18n.getFallbackLocale(), s);
    }

    /**
     * @deprecated Since 1.4.0
     */
    public static String formatWarning(String s) {
        return Main.formatWarning(I18n.getFallbackLocale(), s);
    }

    /**
     * @deprecated Since 1.3.3
     * @param name
     *                  The name of the plugin
     * @param state
     *                  0 for attempt, 1 for success, 2 for failure
     * @return The formatted message
     * @see #reloadMessage(String, boolean)
     */
    @Deprecated
    public static String reloadMessage(String name, int state) {
        return String.format(Main.getReloadMessage(I18n.getFallbackLocale(), state), name);
    }

    /**
     * @deprecated Since 1.4.0
     * @param name
     *                 The name of the plugin
     * @see #reloadMessage(String, boolean)
     */
    public static String reloadAttempt(String name) {
        return String.format(Main.getReloadMessage(I18n.getFallbackLocale(), 0), name);
    }

    /**
     * @deprecated Since 1.4.0
     * @param name
     *                    The name of the plugin
     * @param success
     *                    The success state of the reload method
     * @return The formatted message
     * @see #reloadMessage(String)
     */
    public static String reloadMessage(String name, boolean success) {
        return String.format(Main.getReloadMessage(I18n.getFallbackLocale(), success ? 1 : 2), name);
    }

    /**
     * @deprecated Since 1.4.0
     * @param usage
     *                  The usage of the command
     * @return The formatted message
     */
    public static String usage(String usage) {
        return Main.getUsage(I18n.getFallbackLocale(), usage);
    }

    /**
     * @deprecated Since 1.4.0
     */
    public static String invalidArguments() {
        return Main.getInvalidArgumentsMessage(I18n.getFallbackLocale());
    }

    /**
     * @deprecated Since 1.4.0
     * @param value
     *                  The invalid argument
     * @return The formatted message
     */
    public static String invalidArgument(Object value) {
        return Main.getInvalidArgumentMessage(I18n.getFallbackLocale(), value);
    }

    /**
     * @deprecated Since 1.4.0
     */
    public static String invalidArgumentCount() {
        return Main.getInvalidArgumentCountMessage(I18n.getFallbackLocale());
    }

    /**
     * @deprecated Since 1.4.0
     */
    public static String getPlayersOnlyMessage() {
        return Main.getPlayersOnlyMessage(I18n.getFallbackLocale());
    }

    public static String noPermissionMessage(String locale) {
        return Main.noPermissionMessage(locale);
    }

    public static String formatError(String locale, String s) {
        return Main.formatError(locale, s);
    }

    public static String formatWarning(String locale, String s) {
        return Main.formatWarning(locale, s);
    }

    /**
     * @param name
     *                 The name of the plugin
     * @see #reloadMessage(String, boolean)
     */
    public static String reloadAttempt(String locale, String name) {
        return String.format(Main.getReloadMessage(locale, 0), name);
    }

    /**
     * @param name
     *                    The name of the plugin
     * @param success
     *                    The success state of the reload method
     * @return The formatted message
     * @see #reloadMessage(String)
     */
    public static String reloadMessage(String locale, String name, boolean success) {
        return String.format(Main.getReloadMessage(locale, success ? 1 : 2), name);
    }

    /**
     * @param usage
     *                  The usage of the command
     * @return The formatted message
     */
    public static String usage(String locale, String usage) {
        return Main.getUsage(locale, usage);
    }

    public static String invalidArguments(String locale) {
        return Main.getInvalidArgumentsMessage(locale);
    }

    /**
     * @param value
     *                  The invalid argument
     * @return The formatted message
     */
    public static String invalidArgument(String locale, Object value) {
        return Main.getInvalidArgumentMessage(locale, value);
    }

    public static String invalidArgumentCount(String locale) {
        return Main.getInvalidArgumentCountMessage(locale);
    }

    public static String getPlayersOnlyMessage(String locale) {
        return Main.getPlayersOnlyMessage(locale);
    }

    /**
     * @deprecated Since 1.4.2
     * @see #noPermissionMessage(String)
     */
    public static String noPermissionMessage(CommandSender sender) {
        return noPermissionMessage(I18n.getLocale(sender));
    }

    /**
     * @deprecated Since 1.4.2
     * @see #formatError(String, String)
     */
    public static String formatError(CommandSender sender, String s) {
        return formatError(I18n.getLocale(sender), s);
    }

    /**
     * @deprecated Since 1.4.2
     * @see #formatWarning(String, String)
     */
    public static String formatWarning(CommandSender sender, String s) {
        return formatWarning(I18n.getLocale(sender), s);
    }

    /**
     * @param name
     *                 The name of the plugin
     * @see #reloadMessage(String, boolean)
     * @deprecated Since 1.4.2
     * @see #reloadMessage(String, String)
     */
    public static String reloadAttempt(CommandSender sender, String name) {
        return String.format(Main.getReloadMessage(I18n.getLocale(sender), 0), name);
    }

    /**
     * @param name
     *                    The name of the plugin
     * @param success
     *                    The success state of the reload method
     * @return The formatted message
     * @see #reloadMessage(String)
     * @deprecated Since 1.4.2
     * @see #reloadMessage(String, String, boolean)
     */
    public static String reloadMessage(CommandSender sender, String name, boolean success) {
        return String.format(Main.getReloadMessage(I18n.getLocale(sender), success ? 1 : 2), name);
    }

    /**
     * @param usage
     *                  The usage of the command
     * @return The formatted message
     * @deprecated Since 1.4.2
     * @see #usage(String, String)
     */
    public static String usage(CommandSender sender, String usage) {
        return Main.getUsage(I18n.getLocale(sender), usage);
    }

    /**
     * @deprecated Since 1.4.2
     * @see #invalidArguments(String)
     */
    public static String invalidArguments(CommandSender sender) {
        return Main.getInvalidArgumentsMessage(I18n.getLocale(sender));
    }

    /**
     * @param value
     *                  The invalid argument
     * @return The formatted message
     * @deprecated Since 1.4.2
     * @see #invalidArgument(String, Object)
     */
    public static String invalidArgument(CommandSender sender, Object value) {
        return Main.getInvalidArgumentMessage(I18n.getLocale(sender), value);
    }

    /**
     * @deprecated Since 1.4.2
     * @see #invalidArgumentCount(String)
     */
    public static String invalidArgumentCount(CommandSender sender) {
        return Main.getInvalidArgumentCountMessage(I18n.getLocale(sender));
    }

    /**
     * @deprecated Since 1.4.2
     * @see #getPlayersOnlyMessage(String)
     */
    public static String getPlayersOnlyMessage(CommandSender sender) {
        return Main.getPlayersOnlyMessage(I18n.getLocale(sender));
    }

    /**
     * @param s
     *              The string to format
     * @return The string formatted with chat colors determined by the plugin's
     *         current color scheme.<br>
     *         <code>
     *         <strong>$t</strong>&nbsp;&nbsp;&nbsp;- text<br>
     *         <strong>$hl</strong>&nbsp;&nbsp;- highlight<br>
     *         <strong>$e</strong>&nbsp;&nbsp;&nbsp;- error<br>
     *         <strong>$et</strong>&nbsp;&nbsp;- error text<br>
     *         <strong>$w</strong>&nbsp;&nbsp;&nbsp;- warning<br>
     *         <strong>$wt</strong>&nbsp;&nbsp;- warning text<br>
     *         </code>
     * @see ColorScheme#format(String)
     * @see #format(String, Object...)
     */
    public static String format(String s) {
        return Main.getColorScheme().format(s);
    }

    /**
     * @param s
     *                 The string to format
     * @param args
     *                 The objects to format the string with
     * @return The formatted string
     * @see #format(String)
     * @see String#format(String, Object...)
     */
    public static String format(String s, Object... args) {
        return format(String.format(s, args));
    }

    /**
     * @param locale
     *                   The locale from which to retreive the translation
     * @param key
     *                   The translation key
     * @return The translated string
     * @see #format(String)
     */
    public static String translate(String locale, String key) {
        return format(String.format(translateUnformatted(locale, key)));
    }

    /**
     * @param locale
     *                   The locale from which to retreive the translation
     * @param key
     *                   The translation key
     * @param args
     *                   The objects to format the string with
     * @return The translated and formatted string
     * @see #format(String, Object...)
     */
    public static String translate(String locale, String key, Object... args) {
        return format(translateUnformatted(locale, key), args);
    }

    /**
     * @param locale
     *                   The locale from which to retreive the translation
     * @param key
     *                   The translation key
     * @return The raw translation string with no formatting applied
     */
    public static String translateUnformatted(String locale, String key) {
        return I18n.get(locale, key);
    }

    /**
     * @param key
     *                The translation key
     * @return The translated string
     * @see #format(String)
     * @deprecated Since 1.4.2
     * @see #translate(String, String)
     */
    public static String translate(CommandSender sender, String key) {
        return I18n.get(I18n.getLocale(sender), key);
    }

    /**
     * @param key
     *                 The translation key
     * @param args
     *                 The objects to format the string with
     * @return The translated and formatted string
     * @see #format(String, Object...)
     * @deprecated Since 1.4.2
     * @see #translate(String, String, Object...)
     */
    public static String translate(CommandSender sender, String key, Object... args) {
        return String.format(translate(sender, key), args);
    }

    /**
     * @see #section(String, String)
     */
    public static String header(String title, char c, int width) {
        int remainingWidth = width - (title.length() + 2);
        if(remainingWidth > 0) {
            StringBuilder sb = new StringBuilder();
            int half = remainingWidth / 2;
            int h2 = half * 2;
            if(h2 != remainingWidth) {
                half += h2 < remainingWidth ? 1 : -1;
            }
            sb.append("$t");
            sb.append(ChatColor.STRIKETHROUGH);
            sb.append(footer(c, half, true));
            sb.append("$hl ");
            sb.append(title);
            sb.append(" $t");
            sb.append(ChatColor.STRIKETHROUGH);
            sb.append(footer(c, half, true));
            sb.append("$t");
            return sb.toString();
        } else {
            return format("$hl" + title + "$t");
        }
    }

    /**
     * @see #section(String, String)
     * @see StringUtils#multiply(String, int)
     */
    public static String footer(char c, int width, boolean strikethrough) {
        char[] array = new char[width];
        Arrays.fill(array, c);
        if(strikethrough) {
            return ChatColor.STRIKETHROUGH + new String(array);
        } else {
            return new String(array);
        }
    }

    public static String section(String title, char c, int width, String content) {
        StringBuilder sb = new StringBuilder();
        sb.append(header(title, c, width));
        sb.append("\n");
        sb.append(content);
        sb.append("\n$t");
        sb.append(footer(c, width, true));
        sb.append("$t");
        return format(sb.toString());
    }

    /**
     * Returns a string with the following format: <br>
     * 
     * <pre>
     * -------------------- title ---------------------
     * content
     * ------------------------------------------------
     * </pre>
     * 
     * <br>
     * 
     * <tt>content</tt> will be formatted according to {@link #format(String)}
     */
    public static String section(String title, String content) {
        return section(title, '-', 48, content);
    }
}
