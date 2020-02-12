package controller;

import java.util.Random;

public class Dice {
    private final static Random random = new Random();

    public static int makeRandomNumber() {
        return random.nextInt(9) + 1;
    }
}
