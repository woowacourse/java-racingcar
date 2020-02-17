package racingcar.domain;

import racingcar.domain.Generator.RandomGenerator;

public class Random implements RandomGenerator {
    private static final int RANDOM_VALUE_LIMIT = 10;

    private int randomValue;

    Random() {
        this.randomValue = (int) (Math.random() * RANDOM_VALUE_LIMIT);
    }

    @Override
    public boolean isMovable() {
        return this.randomValue >= RANDOM_VALUE_LIMIT;
    }
}
