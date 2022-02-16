package racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;
    private static final int LOWER_MOVABLE_BOUND = 4;
    private static final Random random = new Random();

    @Override
    public boolean isMove() {
        return random.nextInt(RANDOM_NUMBER_UPPER_BOUND) >= LOWER_MOVABLE_BOUND;
    }
}
