package io.github.meeples10.meepcore;

import net.md_5.bungee.api.ChatColor;

public class ColorScheme {

    private String name;
    private ChatColor text, highlight, error, errorText, warning, warningText;

    protected ColorScheme(String name, ChatColor text, ChatColor highlight, ChatColor error, ChatColor errorText,
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
}