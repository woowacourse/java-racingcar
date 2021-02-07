package racingcar.utils;

import java.util.Random;

public class RandomGenerator {
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;
    private static final Random random = new Random();

    public static int generateRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }
}
