package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator implements RandomUtil {

    private static final int MAX_RANDOM_VALUE = 9;

    @Override
    public int generate() {
        final Random random = new Random();
        return random.nextInt(MAX_RANDOM_VALUE + 1);
    }
}
