package domain;

import java.util.Random;

public class PowerRandomNumberGenerator implements PowerNumberGenerator {
    private static final int RANDOM_NUMBER_RANGE = 10;

    Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
