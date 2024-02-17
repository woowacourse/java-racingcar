package utils;

import java.util.Random;

public class RandomGenerator implements NumberGenerator {

    private final Random random = new Random();

    public int getNumber() {
        return random.nextInt(10);
    }
}
