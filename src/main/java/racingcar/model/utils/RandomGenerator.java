package racingcar.model.utils;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static int makeRandomNumberFromZeroToMax(int number) {
        return random.nextInt(number);
    }
}
