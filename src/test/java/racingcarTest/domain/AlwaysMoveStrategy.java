package racingcarTest.domain;

import racingcar.domain.MoveStrategy;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public int generateNumber() {
        return 9;
    }
}
