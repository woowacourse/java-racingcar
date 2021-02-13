package racingcar.domain.car.strategy;

import racingcar.util.RandomUtils;

public class CarMoveStrategy implements MoveStrategy {

    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MOVABLE_VALUE = 4;

    @Override
    public boolean isMovable() {
        return createRandomValue() >= MOVABLE_VALUE;
    }

    private int createRandomValue() {
        return RandomUtils.generateRandomNumber(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }
}
