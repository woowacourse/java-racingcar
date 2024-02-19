package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator<Integer> {
    private static final RandomNumberGenerator generator = new RandomNumberGenerator();
    private final Random random;

    private RandomNumberGenerator() {
        this.random = new Random();
    }
    
    @Override
    public Integer generate(final Integer minLimit, final Integer maxLimit) {
        validate(minLimit, maxLimit);
        return random.nextInt(maxLimit - minLimit) + minLimit;
    }

    private static void validate(final int minLimit, final int maxLimit) {
        if (minLimit > maxLimit) {
            throw new IllegalStateException();
        }
    }

    public static RandomNumberGenerator getGenerator() {
        return generator;
    }
}
