package io.github.meeples10.meepcore;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    /**
     * @param l
     *            The lower bound
     * @param u
     *            The upper bound
     * @return A random integer between l and u (inclusive)
     */
    public static int randInt(int l, int u) {
        return ThreadLocalRandom.current().nextInt(l, u + 1);
    }

    /**
     * @param l
     *            The lower bound
     * @param u
     *            The upper bound
     * @return a random double between l and u (inclusive)
     */
    public static double randDouble(double l, double u) {
        return ThreadLocalRandom.current().nextDouble(l, u + 1);
    }

    /**
     * @param l
     *            The lower bound
     * @param u
     *            The upper bound
     * @return A random long between l and u (inclusive)
     */
    public static long randLong(long l, long u) {
        return ThreadLocalRandom.current().nextLong(l, u + 1);
    }

    /**
     * @return A random float between 0.0 and 1.0
     */
    public static float randFloat() {
        return ThreadLocalRandom.current().nextFloat();
    }

    /**
     * @param array
     *            An array of objects
     * @return A random object from the array
     */
    public static Object randObject(Object[] array) {
        return array[randInt(0, array.length - 1)];
    }
}