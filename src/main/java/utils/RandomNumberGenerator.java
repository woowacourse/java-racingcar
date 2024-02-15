package utils;

import java.util.Random;

public class RandomNumberGenerator {
    public static int generate() {
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        return random.nextInt(10);
    }
}
