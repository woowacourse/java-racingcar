package racingcar.domain.util;

import racingcar.domain.rule.RandomMoveCondition;

import java.util.Random;

public class RandomNumber implements RandomUtils<Integer> {
    private static final Random random = new Random();

    private final int maximumBound = RandomMoveCondition.MAXIMUM_BOUND;

    @Override
    public Integer generate() {
        return random.nextInt(maximumBound + 1);
    }
}