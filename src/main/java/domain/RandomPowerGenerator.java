package domain;

import java.util.Random;

public class RandomPowerGenerator {
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    public int generate() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }
}
