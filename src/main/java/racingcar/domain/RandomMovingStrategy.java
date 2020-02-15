package racingcar.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_RANGE = 10;
    private static final int RANDOM_MIN = 0;

    private static final Random random = new Random();

    @Override
    public boolean isMovable() {
        return random.nextInt(RANDOM_RANGE) + RANDOM_MIN >= MOVE_THRESHOLD;
    }
}
