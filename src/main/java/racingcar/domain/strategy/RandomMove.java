package racingcar.domain.strategy;

import racingcar.domain.util.Random;

public class RandomMove implements MoveStrategy {
    private static final int MOVE_CRITERIA = 4;
    private static final int RANDOM_VALUE_BOUND = 9;

    @Override
    public boolean isMovable() {
        return Random.makeRandomValue(RANDOM_VALUE_BOUND) >= MOVE_CRITERIA;
    }
}
