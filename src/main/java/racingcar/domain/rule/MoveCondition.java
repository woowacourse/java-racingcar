package racingcar.domain.rule;

import racingcar.domain.util.RandomNumber;

public class MoveCondition implements Condition {
    private final static int DEFAULT_BOUND = 9;
    private final static int MOVABLE = 4;

    @Override
    public boolean isMovable() {
        return RandomNumber.generate(DEFAULT_BOUND) >= MOVABLE;
    }
}
