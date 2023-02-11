package racingcar.domain;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {

    private final int RIGHT_BOUND_EXCLUSIVE = 10;

    public int generate() {
        Random random = new Random();
        return random.nextInt(RIGHT_BOUND_EXCLUSIVE);
    }
}
