package utils;

import java.util.Random;

public class RandomNumberGenerator {
    static Random rand = new Random();
    static final int upperBound = 10;

    public static int randomNumberGenerate() {
        return rand.nextInt(upperBound);
    }
}
