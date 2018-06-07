package io.github.meeples10.meepcore;

import net.md_5.bungee.api.ChatColor;

class ColorSchemes {
    static final ColorScheme DEFAULT = new ColorScheme("DEFAULT", ChatColor.WHITE, ChatColor.GREEN, ChatColor.RED,
            ChatColor.WHITE, ChatColor.YELLOW, ChatColor.WHITE);
    /**
     * A color style similar to that of the Essentials plugin.
     * 
     * @see <a href=
     *      "https://github.com/drtshock/Essentials">https://github.com/drtshock/Essentials</a>
     */
    static final ColorScheme ESSENTIALS = new ColorScheme("ESSENTIALS", ChatColor.GOLD, ChatColor.RED, ChatColor.RED,
            ChatColor.DARK_RED, ChatColor.RED, ChatColor.GOLD);
}