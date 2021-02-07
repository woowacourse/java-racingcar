package racingcar.domain.rule;

import racingcar.domain.util.RandomUtils;
import racingcar.exception.MoveConditionOutOfBoundException;

public class RandomMoveCondition implements MoveCondition {
    private static final int MINIMUM_BOUND = 0;
    public static final int MAXIMUM_BOUND = 9;
    private final static int MOVABLE_BOUND = 4;

    private final RandomUtils<Integer> randomUtils;

    public RandomMoveCondition(RandomUtils<Integer> randomUtils) {
        this.randomUtils = randomUtils;
    }

    @Override
    public boolean isMovable() {
        int randomNumber = randomUtils.generate();

        validateTRandomNumberBound(randomNumber);

        return randomUtils.generate() >= MOVABLE_BOUND;
    }

    private void validateTRandomNumberBound(int randomNumber) {
        if (!(MINIMUM_BOUND <= randomNumber && randomNumber <= MAXIMUM_BOUND)) {
            throw new MoveConditionOutOfBoundException();
        }
    }
}