package net.ddns.meepnet.meepcore;

public class Messages {

    /**
     * @return The plugin's current color scheme
     */
    public static ColorScheme getColorScheme() {
        return Main.getColorScheme();
    }

    public static String noPermissionMessage() {
        return Main.noPermissionMessage();
    }

    public static String formatError(String s) {
        return Main.formatError(s);
    }

    public static String formatWarning(String s) {
        return Main.formatWarning(s);
    }

    /**
     * @deprecated Since 1.3.3
     * @param name
     *            The name of the plugin
     * @param state
     *            0 for attempt, 1 for success, 2 for failure
     * @return The formatted message
     * @see #reloadMessage(String, boolean)
     */
    @Deprecated
    public static String reloadMessage(String name, int state) {
        return String.format(Main.getReloadMessage(state), name);
    }

    /**
     * @param name
     *            The name of the plugin
     * @see #reloadMessage(String, boolean)
     */
    public static String reloadAttempt(String name) {
        return String.format(Main.getReloadMessage(0), name);
    }

    /**
     * @param name
     *            The name of the plugin
     * @param success
     *            The success state of the reload method
     * @return The formatted message
     * @see #reloadMessage(String)
     */
    public static String reloadMessage(String name, boolean success) {
        return String.format(Main.getReloadMessage(success ? 1 : 2), name);
    }

    /**
     * @param usage
     *            The usage of the command
     * @return The formatted message
     */
    public static String usage(String usage) {
        return Main.getUsage(usage);
    }

    public static String invalidArguments() {
        return Main.getInvalidArgumentsMessage();
    }

    /**
     * @param value
     *            The invalid argument
     * @return The formatted message
     */
    public static String invalidArgument(Object value) {
        return Main.getInvalidArgumentMessage(value);
    }

    public static String invalidArgumentCount() {
        return Main.getInvalidArgumentCountMessage();
    }

    public static String getPlayersOnlyMessage() {
        return Main.getPlayersOnlyMessage();
    }

    /**
     * @param s
     *            The string to format
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
     *            The string to format
     * @param args
     *            The objects to format the string with
     * @return The formatted string
     * @see #format(String)
     * @see String#format(String, Object...)
     */
    public static String format(String s, Object... args) {
        return format(String.format(s, args));
    }
}