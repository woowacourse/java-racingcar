package racingcar.utils;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static int generateRandomNumber() {
        return random.nextInt(10);
    }
}
