package racingcarTest.domain;

import racingcar.domain.MoveStrategy;

public class AllMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove() {
        return true;
    }
}
