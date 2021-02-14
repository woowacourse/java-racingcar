package racingcar.utils;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    private RandomUtils() {
        throw new IllegalStateException("RandomUtils is an utility class");
    }

    public static int generate() {
        return nextInt(START_INCLUSIVE, END_INCLUSIVE);
    }

    private static int nextInt(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException();
        }
        if (startInclusive < 0) {
            throw new IllegalArgumentException();
        }
        if (startInclusive == endInclusive) {
            return startInclusive;
        }
        return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
    }
}
