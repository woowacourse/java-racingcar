package racing.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MINIMUM_MOVE_NUMBER = 4;

    @Override
    public boolean isMovable() {
        int randomNumber = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
        return randomNumber >= MINIMUM_MOVE_NUMBER;
    }
}
