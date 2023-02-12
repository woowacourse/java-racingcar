package racingcar.domain;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator{

    private final int MAX_VALUE = 9;

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(MAX_VALUE + 1);
    }
}
