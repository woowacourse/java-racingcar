package racingcar.model.car.strategy;

import racingcar.util.RandomNumberGenerator;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int RANDOM_MIN_BOUND = 0;
    private static final int RANDOM_MAX_BOUND = 10;
    private static final int MOVABLE_BOUNDARY_NUMBER = 4;

    @Override
    public boolean movable() {
        int randomNumber =
                RandomNumberGenerator.pickNumberInRange(RANDOM_MIN_BOUND, RANDOM_MAX_BOUND);

        return randomNumber >= MOVABLE_BOUNDARY_NUMBER;
    }
}
