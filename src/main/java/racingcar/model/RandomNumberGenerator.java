package racingcar.model;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MAX_NUMBER = 10;
    private static final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(MAX_NUMBER);
    }
}
