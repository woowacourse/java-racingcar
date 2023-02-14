package domain;

import java.util.Random;

public class RandomPowerGenerator implements PowerGenerator {
    private static final int RANDOM_UPPER_BOUND_EXCLUSIVE = 10;

    private final Random randomGenerator = new Random();

    @Override
    public int nextPower() {
        return randomGenerator.nextInt(RANDOM_UPPER_BOUND_EXCLUSIVE);
    }
}
