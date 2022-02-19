package racingcar.domain;

import static racingcar.constants.GameConstants.CAN_GO_VALUE;

import racingcar.util.RandomUtils;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean canGo() {
        int number = RandomUtils.generateNumber();
        return number >= CAN_GO_VALUE;
    }
}
