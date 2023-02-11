package racingcar.domain;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {

    private final int RIGHT_BOUND_EXCLUSIVE = 10;

    Random random = new Random();

    public int generate() {
        return random.nextInt(RIGHT_BOUND_EXCLUSIVE);
    }
}
