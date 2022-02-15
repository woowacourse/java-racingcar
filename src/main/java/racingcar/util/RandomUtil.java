package racingcar.util;

import java.util.Random;

public class RandomUtil {
    private static final int RANGE_MAX = 9;
    private static final Random random=new Random();

    public static int generateRandomNumber() {
        return random.nextInt(RANGE_MAX + 1);
    }
}
