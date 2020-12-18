package net.ddns.meepnet.meepcore;

public class ChatUtils {

    /**
     * @param s
     *              The string to broadcast
     * @see #broadcast(String, boolean)
     */
    public static void broadcast(String s) {
        Main.broadcast(s);
    }

    /**
     * @param s
     *                       The string to broadcast
     * @param permission
     *                       Only players with this permission will receive the
     *                       broadcast
     * @see #broadcast(String, boolean)
     */
    public static void broadcast(String s, String permission) {
        Main.broadcast(s, permission);
    }

    /**
     * @deprecated Since 1.2.3
     * @param s
     *                The string to broadcast
     * @param log
     *                If true, logs the message to the server console
     * @see #broadcast(String)
     */
    @Deprecated
    public static void broadcast(String s, boolean log) {
        Main.broadcast(s, log);
    }
}