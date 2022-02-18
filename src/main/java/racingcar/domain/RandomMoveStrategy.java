package racingcar.domain;

import racingcar.util.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_CONDITION = 4;

    @Override
    public boolean canMove() {
        if (RandomUtil.getRandomForCar() >= RANDOM_CONDITION) {
            return true;
        };
        return false;
    }
}
