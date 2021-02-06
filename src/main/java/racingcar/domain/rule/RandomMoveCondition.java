package racingcar.domain.rule;

import racingcar.domain.util.RandomNumber;

public class RandomMoveCondition implements MoveCondition {
    private final static int DEFAULT_BOUND = 9;
    private final static int MOVABLE_BOUND = 4;

    @Override
    public boolean isMovable() {
        return RandomNumber.generate(DEFAULT_BOUND) >= MOVABLE_BOUND;
    }
}
