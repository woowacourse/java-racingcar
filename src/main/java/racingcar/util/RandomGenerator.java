package racingcar.util;

import java.util.Random;

public class RandomGenerator {
    private static final int MIN_START_VALUE = 0;

    public static int generateRandomNumber(int start, int end) {
        Random random = new Random();
        validateRandomNumberRange(start, end);
        return start + random.nextInt(end - start + 1);
    }

    private static void validateRandomNumberRange(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        if (start < MIN_START_VALUE) {
            throw new IllegalArgumentException();
        }
    }
}
