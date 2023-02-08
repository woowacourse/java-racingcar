package racingcar.model.car.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int RANDOM_MAX_BOUND = 10;
    private static final int MOVABLE_BOUNDARY_NUMBER = 4;
    @Override
    public boolean movable() {
        Random ran = new Random();
        int x = ran.nextInt(RANDOM_MAX_BOUND);

        return x >= MOVABLE_BOUNDARY_NUMBER;
    }
}
