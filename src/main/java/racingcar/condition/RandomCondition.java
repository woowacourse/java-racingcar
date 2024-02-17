package racingcar.condition;

import racingcar.domain.RandomGenerator;

public class RandomCondition implements MovingCarCondition {
    private static final int UPPER_BOUND = 10;
    private static final int THRESHOLD = 4;

    @Override
    public boolean isSatisfied() {
        int number = RandomGenerator.getRandomNumberUnder(UPPER_BOUND);
        return number >= THRESHOLD;
    }
}
