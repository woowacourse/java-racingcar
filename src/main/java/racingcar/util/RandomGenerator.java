package racingcar.util;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static int createRandom(int min, int max) {
        return RandomGenerator.random.nextInt(max - min) + min;
    }
}
