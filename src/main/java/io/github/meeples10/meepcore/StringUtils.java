package io.github.meeples10.meepcore;

public class StringUtils {
    /**
     * @param input
     *            The input string
     * @return The input string with the first letter capitalized
     */
    public static String capitalize(String input) {
        return (input.substring(0, 1).toUpperCase() + input.substring(1));
    }

    /**
     * @param input
     *            The input string
     * @param replacement
     *            The string to replace special characters with
     * @return The input string with all non-alphanumeric characters replaced with
     *         the replacement string
     * @see #removeSpecial(String)
     */
    public static String replaceSpecial(String input, String replacement) {
        return input.replaceAll("[^a-zA-Z0-9]+", replacement);
    }

    /**
     * @param input
     *            The input string
     * @return The input string without non-alphanumeric characters
     * @see #replaceSpecial(String, String)
     */
    public static String removeSpecial(String input) {
        return replaceSpecial(input, "");
    }

    /**
     * @param s
     *            The input string
     * @param amount
     *            The amount of times to duplicate the string
     * @return The input string duplicated the specified amount of times
     */
    public static String multiply(String s, int amount) {
        String out = s;
        for(int i = 0; i < amount; i++) {
            out += s;
        }
        return out;
    }
}