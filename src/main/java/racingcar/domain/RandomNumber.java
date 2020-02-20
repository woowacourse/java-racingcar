package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    private static final int MAX_RANDOM_NUMBER = 9;

    private Random random = new Random();

    public int generateNumber() {
        return generateRandomNumber();
    }

    private int generateRandomNumber() {
        return random.nextInt(MAX_RANDOM_NUMBER + 1);
    }
}
