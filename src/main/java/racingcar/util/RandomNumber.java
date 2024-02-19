package racingcar.util;

import java.util.Random;

public class RandomNumber implements RandomUtils {
    private static final RandomNumber instance = new RandomNumber();
    private final Random random;

    private RandomNumber() {
        this.random = new Random();
    }

    public static RandomNumber getInstance() {
        return instance;
    }

    @Override
    public int generate(final int minLimit, final int maxLimit) {
        validate(minLimit, maxLimit);
        return random.nextInt(maxLimit - minLimit) + minLimit;
    }

    private static void validate(final int minLimit, final int maxLimit) {
        if (minLimit > maxLimit) {
            throw new IllegalStateException();
        }
    }
}
