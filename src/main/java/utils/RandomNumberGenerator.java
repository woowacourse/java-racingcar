package utils;

import java.util.Random;

public class RandomNumberGenerator {

    public static final int RANDOM_NUMBER_BOUND = 10;

    public int generateRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_BOUND);
    }
}
