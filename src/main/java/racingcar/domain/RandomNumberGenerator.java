package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator{
    private static final int MAX_RANDOM_NUMBER = 10;

    public static int generateNumber() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER);
    }
}
