package utils;

import java.util.Random;

public class RandomGenerator {
    public static int getNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
