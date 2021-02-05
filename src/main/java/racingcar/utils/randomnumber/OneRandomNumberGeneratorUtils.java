package racingcar.utils.randomnumber;

import java.util.Random;

public class OneRandomNumberGeneratorUtils {
    private static final Random RANDOM = new Random();
    private static final int MIN_START_INCLUSIVE_NUMBER = 0;

    private OneRandomNumberGeneratorUtils() {
    }

    public static int generateOneRandomNumber(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException();
        }
        if (startInclusive < MIN_START_INCLUSIVE_NUMBER) {
            throw new IllegalArgumentException();
        }
        if (startInclusive == endInclusive) {
            return startInclusive;
        }
        return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
    }
}
