package net.ddns.meepnet.meepcore;

import org.bukkit.command.CommandSender;

public class Messages {

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
        return Main.noPermissionMessage(LocalizationUtils.getFallbackLocale());
    }

    /**
     * @deprecated Since 1.4.0
     */
    public static String formatError(String s) {
        return Main.formatError(LocalizationUtils.getFallbackLocale(), s);
    }

    /**
     * @deprecated Since 1.4.0
     */
    public static String formatWarning(String s) {
        return Main.formatWarning(LocalizationUtils.getFallbackLocale(), s);
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
        return String.format(Main.getReloadMessage(LocalizationUtils.getFallbackLocale(), state), name);
    }

    /**
     * @deprecated Since 1.4.0
     * @param name
     *                 The name of the plugin
     * @see #reloadMessage(String, boolean)
     */
    public static String reloadAttempt(String name) {
        return String.format(Main.getReloadMessage(LocalizationUtils.getFallbackLocale(), 0), name);
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
        return String.format(Main.getReloadMessage(LocalizationUtils.getFallbackLocale(), success ? 1 : 2), name);
    }

    /**
     * @deprecated Since 1.4.0
     * @param usage
     *                  The usage of the command
     * @return The formatted message
     */
    public static String usage(String usage) {
        return Main.getUsage(LocalizationUtils.getFallbackLocale(), usage);
    }

    /**
     * @deprecated Since 1.4.0
     */
    public static String invalidArguments() {
        return Main.getInvalidArgumentsMessage(LocalizationUtils.getFallbackLocale());
    }

    /**
     * @deprecated Since 1.4.0
     * @param value
     *                  The invalid argument
     * @return The formatted message
     */
    public static String invalidArgument(Object value) {
        return Main.getInvalidArgumentMessage(LocalizationUtils.getFallbackLocale(), value);
    }

    /**
     * @deprecated Since 1.4.0
     */
    public static String invalidArgumentCount() {
        return Main.getInvalidArgumentCountMessage(LocalizationUtils.getFallbackLocale());
    }

    /**
     * @deprecated Since 1.4.0
     */
    public static String getPlayersOnlyMessage() {
        return Main.getPlayersOnlyMessage(LocalizationUtils.getFallbackLocale());
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

    public static String noPermissionMessage(CommandSender sender) {
        return Main.noPermissionMessage(LocalizationUtils.getLocale(sender));
    }

    public static String formatError(CommandSender sender, String s) {
        return Main.formatError(LocalizationUtils.getLocale(sender), s);
    }

    public static String formatWarning(CommandSender sender, String s) {
        return Main.formatWarning(LocalizationUtils.getLocale(sender), s);
    }

    /**
     * @param name
     *                 The name of the plugin
     * @see #reloadMessage(String, boolean)
     */
    public static String reloadAttempt(CommandSender sender, String name) {
        return String.format(Main.getReloadMessage(LocalizationUtils.getLocale(sender), 0), name);
    }

    /**
     * @param name
     *                    The name of the plugin
     * @param success
     *                    The success state of the reload method
     * @return The formatted message
     * @see #reloadMessage(String)
     */
    public static String reloadMessage(CommandSender sender, String name, boolean success) {
        return String.format(Main.getReloadMessage(LocalizationUtils.getLocale(sender), success ? 1 : 2), name);
    }

    /**
     * @param usage
     *                  The usage of the command
     * @return The formatted message
     */
    public static String usage(CommandSender sender, String usage) {
        return Main.getUsage(LocalizationUtils.getLocale(sender), usage);
    }

    public static String invalidArguments(CommandSender sender) {
        return Main.getInvalidArgumentsMessage(LocalizationUtils.getLocale(sender));
    }

    /**
     * @param value
     *                  The invalid argument
     * @return The formatted message
     */
    public static String invalidArgument(CommandSender sender, Object value) {
        return Main.getInvalidArgumentMessage(LocalizationUtils.getLocale(sender), value);
    }

    public static String invalidArgumentCount(CommandSender sender) {
        return Main.getInvalidArgumentCountMessage(LocalizationUtils.getLocale(sender));
    }

    public static String getPlayersOnlyMessage(CommandSender sender) {
        return Main.getPlayersOnlyMessage(LocalizationUtils.getLocale(sender));
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
        return LocalizationUtils.getTranslation(locale, key);
    }

    /**
     * @param key
     *                The translation key
     * @return The translated string
     * @see #format(String)
     */
    public static String translate(CommandSender sender, String key) {
        return LocalizationUtils.getTranslation(LocalizationUtils.getLocale(sender), key);
    }

    /**
     * @param key
     *                 The translation key
     * @param args
     *                 The objects to format the string with
     * @return The translated and formatted string
     * @see #format(String, Object...)
     */
    public static String translate(CommandSender sender, String key, Object... args) {
        return String.format(translate(sender, key), args);
    }
}