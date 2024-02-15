package util;

import java.util.Random;

public class RandomNumber {
    private static final int MAX_NUMBER_RANGE = 10;
    private static Random random = new Random();

    private RandomNumber() {
    }

    public static int getRandomNumber() {
        return random.nextInt(MAX_NUMBER_RANGE);
    }
}
