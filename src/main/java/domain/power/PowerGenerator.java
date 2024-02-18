package domain.power;

import java.util.Random;

public enum PowerGenerator {
    POWER_GENERATOR;

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final Random random = new Random();

    public Power generateRandomPowerInRange(final int start, final int end) {
        return new Power(random.nextInt(end - start) + start);
    }

    public Power generateRandomPower() {
        return generateRandomPowerInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
