package utils;

import java.util.Random;

public class RandomGenerator implements NumberGenerator {
    public int getNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
