package racingcar.domain;

import racingcar.utils.Randoms;

public class RandomMovingPolicy implements MovingPolicy {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVE_CONDITION = 4;

    public boolean isMovable() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= MOVE_CONDITION;
    }
}
