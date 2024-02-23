package racingcar.domain.power;

import java.util.Random;

public class RandomPowerGenerator implements PowerGenerator {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final Random random = new Random();

    public Power generatePower() {
        return generateRandomPowerInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    private Power generateRandomPowerInRange(final int start, final int end) {
        return new Power(random.nextInt(end - start) + start);
    }
}
