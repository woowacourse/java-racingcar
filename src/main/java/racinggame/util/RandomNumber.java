package racinggame.util;

import java.util.Random;

public class RandomNumber {
    private static final int RANDOM_BOUND = 10;

    public static int generateRandomNumber() {
        Random random = new Random();

        return random.nextInt(RANDOM_BOUND);
    }
}
