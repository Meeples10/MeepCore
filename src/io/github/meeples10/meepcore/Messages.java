package io.github.meeples10.meepcore;

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
     * @param name
     *            The name of the plugin
     * @param state
     *            0 for attempt, 1 for success, 2 for failure
     * @return The formatted message
     */
    public static String reloadMessage(String name, int state) {
        return String.format(Main.getReloadMessage(state), name);
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
     *         <strong>$t</strong>&nbsp;&nbsp;&nbsp;- text<br>
     *         <strong>$hl</strong>&nbsp;&nbsp;- highlight<br>
     *         <strong>$e</strong>&nbsp;&nbsp;&nbsp;- error<br>
     *         <strong>$et</strong>&nbsp;&nbsp;- error text<br>
     *         <strong>$w</strong>&nbsp;&nbsp;&nbsp;- warning<br>
     *         <strong>$wt</strong>&nbsp;&nbsp;- warning text<br>
     */
    public static String format(String s) {
        return format(s, "$t", "$hl", "$e", "$et", "$w", "$wt");
    }

    public static String format(String s, String text, String highlight) {
        return s.replace(text, Main.getColorScheme().t() + "").replace(highlight, Main.getColorScheme().hl() + "");
    }

    public static String format(String s, String text, String highlight, String error, String errorText, String warning,
            String warningText) {
        return s.replace(text, Main.getColorScheme().t() + "").replace(highlight, Main.getColorScheme().hl() + "")
                .replace(errorText, Main.getColorScheme().errorText() + "")
                .replace(error, Main.getColorScheme().error() + "")
                .replace(warningText, Main.getColorScheme().warningText() + "")
                .replace(warning, Main.getColorScheme().warning() + "");
    }
}