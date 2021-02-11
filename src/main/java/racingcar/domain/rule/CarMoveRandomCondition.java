package racingcar.domain.rule;

import racingcar.domain.util.RandomNumber;

public class CarMoveRandomCondition implements CarMoveCondition {
    private static final int DEFAULT_BOUND = 9;
    private static final int MOVABLE_BOUND = 4;

    @Override
    public boolean isMovable() {
        return RandomNumber.generate(DEFAULT_BOUND) >= MOVABLE_BOUND;
    }
}
