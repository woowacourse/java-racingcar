package domain;

import java.util.Random;

public class RandomNumber {
    private static final int RANDOM_BOUND = 10;
    private static final Random random = new Random();

    static int getRandomNumber() {
        return random.nextInt(RANDOM_BOUND);
    }
}
