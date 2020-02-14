package model;

import java.util.Random;

public class Dice {
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int ONE = 1;
    private final static Random RANDOM = new Random();

    public static int makeRandomNumber() {
        return RANDOM.nextInt(MAX_RANDOM_NUMBER + ONE);
    }
}
