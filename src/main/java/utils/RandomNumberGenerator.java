package utils;

import java.util.Random;

public class RandomNumberGenerator {

    public static final int RANDOM_NUMBER_BOUND = 10;

    private RandomNumberGenerator() {}

    public static RandomNumberGenerator makeInstance() {
        return new RandomNumberGenerator();
    }

    public int generateRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_BOUND);
    }
}
