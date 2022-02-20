package racingcar.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final Random random = new Random();
    private static final int RANGE = 10;
    private static final int THRESHOLD = 4;

    public boolean isMovable() {
        return random.nextInt(RANGE) >= THRESHOLD;
    }
}
