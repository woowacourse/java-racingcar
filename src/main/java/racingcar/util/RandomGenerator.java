package racingcar.util;

import java.util.Random;

public class RandomGenerator {

   private static final int MAX_RANDOM_NUMBER = 10;

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER);
    }
}
