package model.intgenerator;

import java.util.Random;

public class RandomIntGenerator implements IntGenerator {
    private static final int NUMBER_BOUND = 10;

    @Override
    public int pickNumber() {
        Random random = new Random();
        return random.nextInt(NUMBER_BOUND);
    }
}
