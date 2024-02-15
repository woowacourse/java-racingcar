package racingcar.domain.generator;

import racingcar.utils.RandomUtils;

public class RandomNumberGenerator implements NumberGenerator{
    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 9;

    @Override
    public int generate() {
        return RandomUtils.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }
}
