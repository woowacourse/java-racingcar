package racingcar.domain;

import java.util.Random;
import java.util.function.IntPredicate;

public class MovePredicate implements IntPredicate {
    private static final int MOVE_CRITERIA = 4;
    private static final int RANDOM_VALUE_BOUND = 9;
    private static final Random RANDOM = new java.util.Random();

    public boolean testRandom() {
        return test(RANDOM.nextInt(RANDOM_VALUE_BOUND + 1));
    }

    @Override
    public boolean test(int value) {
        return value >= MOVE_CRITERIA;
    }
}
