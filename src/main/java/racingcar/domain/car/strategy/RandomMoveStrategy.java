package racingcar.domain.car.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int CONDITION_TO_MOVE = 4;
    private static final int EXCLUSIVE_RANDOM_START = 10;
    private static final int INCLUSIVE_RANDOM_START = 0;
    private final Random random;

    public RandomMoveStrategy() {
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    @Override
    public boolean isPossibleToMove() {
        return pickOne() >= CONDITION_TO_MOVE;
    }

    private int pickOne() {
        final int size = EXCLUSIVE_RANDOM_START - INCLUSIVE_RANDOM_START;
        return random.nextInt(size) + INCLUSIVE_RANDOM_START;
    }

}
