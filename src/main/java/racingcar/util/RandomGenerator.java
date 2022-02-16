package racingcar.util;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();
    private static final int RANGE = 10;

    public static int generateRandomNumber() {
        return random.nextInt(RANGE);
    }
}
