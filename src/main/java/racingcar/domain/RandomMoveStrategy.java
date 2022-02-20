package racingcar.domain;

import racingcar.util.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public int generateNumber() {
        return RandomUtil.getRandomForCar();
    }
}
