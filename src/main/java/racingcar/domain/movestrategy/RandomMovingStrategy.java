package racingcar.domain.movestrategy;

import racingcar.util.RandomUtil;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int PROGRESS_CONDITION_VALUE = 4;

    @Override
    public boolean isMovable() {
        int randomNumber = RandomUtil.getRandomNumber();

        return randomNumber >= PROGRESS_CONDITION_VALUE;
    }
}
