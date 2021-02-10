package racingcar.utils;

import java.util.Random;

public class RandomUtils {

    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_NINE = 9;

    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int betweenZeroToNine() {
        return nextPositiveInt(NUMBER_ZERO, NUMBER_NINE);
    }

    public static int nextPositiveInt(final int startInclusive, final int endInclusive) {
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

