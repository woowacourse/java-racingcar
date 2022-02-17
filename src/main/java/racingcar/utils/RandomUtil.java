package racingcar.utils;

import java.util.Random;

public class RandomUtil {

    private static final RandomUtil RANDOM_UTIL = new RandomUtil();
    private final Random random;

    private RandomUtil() {
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    public static int pickNumberInRange(final int inclusiveStart, final int exclusiveEnd) {
        return RANDOM_UTIL.pickNumber(inclusiveStart, exclusiveEnd);
    }

    private int pickNumber(int inclusiveStart, int exclusiveEnd) {
        final int size = exclusiveEnd - inclusiveStart;
        return random.nextInt(size) + inclusiveStart;
    }

}
