package racingcar.domain.rule;

import racingcar.domain.util.RandomUtil;
import racingcar.exception.MoveConditionOutOfBoundException;

public class RandomMoveCondition implements MoveCondition {
    private static final int MINIMUM_BOUND = 0;
    public static final int MAXIMUM_BOUND = 9;
    private final static int MOVABLE_BOUND = 4;

    private final RandomUtil<Integer> randomUtil;

    public RandomMoveCondition(RandomUtil<Integer> randomUtils) {
        this.randomUtil = randomUtils;
    }

    @Override
    public boolean isMovable() {
        int randomNumber = randomUtil.generate(MAXIMUM_BOUND);

        validateTRandomNumberBound(randomNumber);

        return randomNumber >= MOVABLE_BOUND;
    }

    private void validateTRandomNumberBound(int randomNumber) {
        if (!(MINIMUM_BOUND <= randomNumber && randomNumber <= MAXIMUM_BOUND)) {
            throw new MoveConditionOutOfBoundException();
        }
    }
}