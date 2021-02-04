package racingcar.domain.rule;

import racingcar.domain.util.RandomNumber;

public class MoveCondition {
    private final static int DEFAULT_BOUND = 9;
    private final static int MOVABLE = 4;
    private final static int STOP = 3;

    public static boolean isMovable() {
        return RandomNumber.generate(DEFAULT_BOUND) >= MOVABLE;
    }
}
