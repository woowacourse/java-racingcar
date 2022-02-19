package racingcar.domain.strategy;

import java.util.function.IntPredicate;

import racingcar.domain.util.Random;

public class MovePredicate implements IntPredicate {
    private static final int MOVE_CRITERIA = 4;
    private static final int RANDOM_VALUE_BOUND = 9;

    public boolean testRandom() {
        return test(Random.makeRandomValue(RANDOM_VALUE_BOUND));
    }

    @Override
    public boolean test(int value) {
        return value >= MOVE_CRITERIA;
    }
}
