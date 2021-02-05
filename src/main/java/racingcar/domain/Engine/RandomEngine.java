package racingcar.domain.Engine;

import racingcar.utils.RandomUtils;

public class RandomEngine implements Engine {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    @Override
    public boolean isMove() {
        return RandomUtils.nextInt(MIN_VALUE, MAX_VALUE) > MOVABLE_DIGIT;
    }
}
