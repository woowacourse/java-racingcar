package racingcar.util;

import java.util.Random;

public class RandomUtil {
    private static final RandomUtil instance = new RandomUtil();
    private final Random random;

    private RandomUtil() {
        this.random = new Random();
    }

    public static RandomUtil getInstance() {
        return instance;
    }

    /**
     * minLimit와 maxLimit을 포함하여 랜담값을 뽑는 함수
     *
     * @param minLimit
     * @param maxLimit
     * @return int
     */
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
