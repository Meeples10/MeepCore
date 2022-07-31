package io.github.meeples10.meepcore;

import org.bukkit.ChatColor;

public class ColorScheme {
    private String name;
    private ChatColor text, highlight, error, errorText, warning, warningText;

    public ColorScheme(String name, ChatColor text, ChatColor highlight, ChatColor error, ChatColor errorText,
            ChatColor warning, ChatColor warningText) {
        this.name = name;
        this.text = text;
        this.highlight = highlight;
        this.error = error;
        this.errorText = errorText;
        this.warning = warning;
        this.warningText = warningText;
    }

    /**
     * @return The name of the color scheme
     */
    public String getName() {
        return name;
    }

    /**
     * @return The default color of the color scheme
     */
    public ChatColor t() {
        return text;
    }

    /**
     * @return The highlight color of the color scheme
     */
    public ChatColor hl() {
        return highlight;
    }

    /**
     * @return The error color of the color scheme
     */
    public ChatColor error() {
        return error;
    }

    /**
     * @return The error text color of the color scheme
     */
    public ChatColor errorText() {
        return errorText;
    }

    /**
     * @return The warning color of the color scheme
     */
    public ChatColor warning() {
        return warning;
    }

    /**
     * @return The warning text color of the color scheme
     */
    public ChatColor warningText() {
        return warningText;
    }

    /**
     * @param s
     *              The string to format
     * @return The string formatted with chat colors determined by the color
     *         scheme.<br>
     *         <strong>$t</strong>&nbsp;&nbsp;&nbsp;- text<br>
     *         <strong>$hl</strong>&nbsp;&nbsp;- highlight<br>
     *         <strong>$e</strong>&nbsp;&nbsp;&nbsp;- error<br>
     *         <strong>$et</strong>&nbsp;&nbsp;- error text<br>
     *         <strong>$w</strong>&nbsp;&nbsp;&nbsp;- warning<br>
     *         <strong>$wt</strong>&nbsp;&nbsp;- warning text<br>
     */
    public String format(String s) {
        return format(s, "$t", "$hl", "$e", "$et", "$w", "$wt");
    }

    private String format(String s, String text, String highlight, String error, String errorText, String warning,
            String warningText) {
        return s.replace(text, this.text + "").replace(highlight, this.highlight + "")
                .replace(errorText, this.errorText + "").replace(error, this.error + "")
                .replace(warningText, this.warningText + "").replace(warning, this.warning + "");
    }
}
