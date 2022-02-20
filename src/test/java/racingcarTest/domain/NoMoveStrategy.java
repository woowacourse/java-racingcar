package racingcarTest.domain;

import racingcar.domain.MoveStrategy;

public class NoMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove() {
        return false;
    }
}
