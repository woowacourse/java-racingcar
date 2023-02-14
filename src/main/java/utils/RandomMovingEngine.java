package utils;

import java.util.Random;

public class RandomMovingEngine implements Engine {
    private final static Random random = new Random();
    private final static int RANDOM_RANGE = 10;

    @Override
    public int generatePower() {
        return random.nextInt(RANDOM_RANGE);
    }
}
