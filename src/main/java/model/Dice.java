package model;

import java.util.Random;

public class Dice {
    private final static Random random = new Random();
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int ONE = 1;

    public static int makeRandomNumber() {
        return random.nextInt(MAX_RANDOM_NUMBER + ONE);
    }
}
