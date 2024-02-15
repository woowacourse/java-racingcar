package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int RANDOM_BOUND = 10;

    public static int generate() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }
}
