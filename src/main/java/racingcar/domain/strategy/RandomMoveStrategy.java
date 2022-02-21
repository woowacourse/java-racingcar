package racingcar.domain.strategy;

import racingcar.util.RandomUtils;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_MIN = 0;
    private static final int MOVE_MAX = 9;
    private static final int STANDARD_VALUE = 4;
    private static final int MOVING_DISTANCE = 1;

    @Override
    public int move() {
        int random = RandomUtils.generateNumber(MOVE_MIN, MOVE_MAX + 1);
        if (random >= STANDARD_VALUE) {
            return MOVING_DISTANCE;
        }
        return 0;
    }
}
