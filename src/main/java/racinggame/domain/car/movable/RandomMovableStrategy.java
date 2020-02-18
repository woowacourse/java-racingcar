package racinggame.domain.car.movable;

import java.util.Random;

public class RandomMovableStrategy implements MovAbleStrategy {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int FORWARD_NUMBER = 4;
    private static final Random random = new Random(System.currentTimeMillis());
    public boolean isMovable() {
        return random.nextInt(RANDOM_NUMBER_BOUND) > FORWARD_NUMBER;
    }
}
