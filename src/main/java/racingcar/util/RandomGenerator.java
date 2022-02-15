package racingcar.util;

import java.util.Random;

public class RandomGenerator implements RandomGeneratable {
    private static final Random random = new Random();

    public int generateNumber(int min, int max) {
        return RandomGenerator.random.nextInt(max - min) + min;
    }
}
