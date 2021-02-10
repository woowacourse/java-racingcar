package racingcar.utils;

import java.util.Random;

public class RandomUtil {
    private static final int MAXIMUM_BOUND = 10;
    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int nextInt(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException();
        }

        if (startInclusive < 0) {
            throw new IllegalArgumentException();
        }

        if (startInclusive == endInclusive) {
            return startInclusive;
        }

        return RANDOM.nextInt(MAXIMUM_BOUND);
    }
}
