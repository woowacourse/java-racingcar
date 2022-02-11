package racingcar.domain.random;

import java.util.Random;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {

    private static final int UPPER_BOUNDARY = 10;

    private final Random random;

    public DefaultRandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public int getRandomNumber() {
        return random.nextInt(UPPER_BOUNDARY);
    }
}
