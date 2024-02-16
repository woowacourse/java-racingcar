package racingcar.domain;

import racingcar.util.RandomNumber;
import racingcar.util.RandomUtil;

public interface CarMoveStrategy {
    RandomUtil randomUtil = new RandomNumber();
    int MOVE_BOUNDARY = 4;
    int RANDOM_MIN_LIMIT = 0;
    int RANDOM_MAX_LIMIT = 9;

    default boolean isMovable() {
        return randomUtil.generate(RANDOM_MIN_LIMIT, RANDOM_MAX_LIMIT) >= MOVE_BOUNDARY;
    }
}
