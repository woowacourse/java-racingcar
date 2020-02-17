package racingcar.domain;

import racingcar.domain.Generator.RandomGenerator;

public class Random implements RandomGenerator {
    private static final int RANDOM_VALUE_LIMIT = 10;
    private static final int FORWARD_NUMBER = 4;

    private int randomValue;

    public Random() {
        this.randomValue = (int) (Math.random() * RANDOM_VALUE_LIMIT);
    }

    @Override
    public boolean isMovable() {
        return this.randomValue >= FORWARD_NUMBER;
    }
}
