package utils;

import java.util.Random;

public class RandomPowerGenerator implements PowerGenerator {
    private static final Random random = new Random();

    public int getNumber() {
        return random.nextInt(10);
    }
}
