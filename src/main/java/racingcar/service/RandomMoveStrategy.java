package racingcar.service;

import java.util.Random;

public class RandomMoveStrategy extends MoveStrategy {
    private static final int STOP_BOUNDARY = 3;
    private static final int MAX_RANDOM_VALUE = 10;

    private final Random random;

    public RandomMoveStrategy() {
        this.random = new Random();
    }

    @Override
    public boolean isMovable() {
        int number = random.nextInt(MAX_RANDOM_VALUE);
        return number > STOP_BOUNDARY;
    }
}
