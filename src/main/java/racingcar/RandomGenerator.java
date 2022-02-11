package racingcar;

import java.util.Random;

public class RandomGenerator {

    private static Random random;

    public RandomGenerator() {
        random = new Random();
    }

    public static int generateRandomNumber() {
        return random.nextInt(10);
    }
}
