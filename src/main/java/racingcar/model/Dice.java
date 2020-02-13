package racingcar.model;

import java.util.Random;

public class Dice {
    private final static Random random = new Random();
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER = 1;

    public static int makeRandomNumber() {
        return random.nextInt(MAX_RANDOM_NUMBER) + MIN_RANDOM_NUMBER;
    }
}
