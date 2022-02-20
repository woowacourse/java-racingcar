package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {

    public static int generateRandomNumber(int minBound, int maxBound) {
        Random random = new Random();
        return random.nextInt(maxBound - minBound + 1) + minBound;
    }
}
