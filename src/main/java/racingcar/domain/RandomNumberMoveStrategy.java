package racingcar.domain;

import racingcar.util.RandomUtil;

public class RandomNumberMoveStrategy implements MoveStrategy {
    private static final int DO_NOT_MOVE_THRESHOLD = 3;

    @Override
    public boolean isMovable() {
        return getMoveValue() > DO_NOT_MOVE_THRESHOLD;
    }

    private int getMoveValue() {
        return RandomUtil.generateRandomNumber();
    }
}
