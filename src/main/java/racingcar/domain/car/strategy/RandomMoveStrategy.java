package racingcar.domain.car.strategy;

import racingcar.utils.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int INCLUSIVE_RANDOM_START = 0;
    private static final int EXCLUSIVE_RANDOM_END = 10;
    private static final int CONDITION_TO_MOVE = 4;

    @Override
    public boolean isMovable() {
        return pickOne() >= CONDITION_TO_MOVE;
    }

    private int pickOne() {
        return RandomUtil.pickNumberInRange(INCLUSIVE_RANDOM_START, EXCLUSIVE_RANDOM_END);
    }

}
