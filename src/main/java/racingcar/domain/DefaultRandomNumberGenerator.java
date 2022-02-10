package racingcar.domain;

import java.util.Random;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {

    private final Random random;

    public DefaultRandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public int getRandomNumber() {
        return random.nextInt(10);
    }
}
