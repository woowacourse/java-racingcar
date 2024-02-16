package racingcar.util;

import java.util.Random;

public class RandomNumber implements RandomUtil {
    private static final Random random = new Random();

    private static void validate(int minLimit, int maxLimit) {
        if (minLimit > maxLimit) {
            throw new IllegalStateException();
        }
    }

    @Override
    public int generate(int minLimit, int maxLimit) {
        validate(minLimit, maxLimit);
        return random.nextInt(maxLimit - minLimit) + minLimit;
    }
}
