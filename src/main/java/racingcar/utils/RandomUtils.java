package racingcar.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    private RandomUtils() {
    }

    private static final Random random = ThreadLocalRandom.current();

    public static int pickNumberInRange(int startInclusive, int endInclusive) {
        validateRange(startInclusive, endInclusive);
        return startInclusive + random.nextInt(endInclusive - startInclusive + 1);
    }

    private static void validateRange(int startInclusive, int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("startInclusive는 endInclusive보다 작거나 같아야 합니다.");
        }
    }
}
