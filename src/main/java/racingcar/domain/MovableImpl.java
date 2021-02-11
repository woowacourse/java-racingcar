package racingcar.domain;

import racingcar.utils.RandomUtils;

public class MovableImpl implements Movable {
    private static final int MINIMUM_RANDOM_VALUE = 0;
    private static final int MAXIMUM_RANDOM_VALUE = 9;

    @Override
    public int extractRandom() {
        return RandomUtils.nextInt(MINIMUM_RANDOM_VALUE, MAXIMUM_RANDOM_VALUE);
    }
}
