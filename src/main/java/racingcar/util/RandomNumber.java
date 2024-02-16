package racingcar.util;

import java.util.Random;

public class RandomNumber implements RandomUtil {
    private static final String SHOULD_NOT_MIN_LARGER_THAN_MAX = "랜덤 최소값이 랜덤 최대값보다 클 수 없습니다.";
    private static final Random random = new Random();

    private static void validate(int minLimit, int maxLimit) {
        if (minLimit > maxLimit) {
            throw new IllegalStateException(SHOULD_NOT_MIN_LARGER_THAN_MAX);
        }
    }

    @Override
    public int generate(int minLimit, int maxLimit) {
        validate(minLimit, maxLimit);
        return random.nextInt(maxLimit - minLimit) + minLimit;
    }
}
