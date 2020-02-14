package racingcar.model;

import java.util.Random;

public class Dice {
    private final static Random random = new Random();
    private static final int MAX_RANDOM_NUMBER = 10;

    public static int makeRandomNumber() {
        return random.nextInt(MAX_RANDOM_NUMBER);
    }
}
