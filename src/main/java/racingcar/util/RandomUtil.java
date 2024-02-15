package racingcar.util;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    /**
     * minLimit와 maxLimit을 포함하여 랜담값을 뽑는 함수
     *
     * @param minLimit
     * @param maxLimit
     * @return int
     */
    public static int pickRandomNumber(int minLimit, int maxLimit) {
        validate(minLimit, maxLimit);
        return random.nextInt(maxLimit - minLimit) + minLimit;
    }

    private static void validate(int minLimit, int maxLimit) {
        if (minLimit > maxLimit) {
            throw new IllegalStateException();
        }
    }
}
