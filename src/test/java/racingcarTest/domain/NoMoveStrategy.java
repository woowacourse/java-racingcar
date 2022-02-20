package racingcarTest.domain;

import racingcar.domain.MoveStrategy;

public class NoMoveStrategy implements MoveStrategy {
    @Override
    public int generateNumber() {
        return 0;
    }
}
