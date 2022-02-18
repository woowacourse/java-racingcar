package racingcar.util;

import java.util.Random;

public class RandomUtil {
    private static final int RANDOM_MAX_RANGE = 10;
    private static final Random random = new Random();

    public static int getRandomNum() {
        return random.nextInt(RANDOM_MAX_RANGE);
    }
}
