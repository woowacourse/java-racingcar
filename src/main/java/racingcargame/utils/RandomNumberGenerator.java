package racingcargame.utils;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int MAX_NUMBER = 10;

    private RandomNumberGenerator() {
    }

    public static int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER);
    }
}
