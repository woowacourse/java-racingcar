package racingcar.domain;

import racingcar.utils.RandomUtils;

public class RandomMove implements MoveStrategy {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    @Override
    public int moveValue() {
        return RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
    }
}
