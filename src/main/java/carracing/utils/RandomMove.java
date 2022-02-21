package carracing.utils;

import java.util.Random;

public class RandomMove implements MoveStrategy {
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MOVABLE_NUMBER_THRESHOLD = 4;
    private static final Random random = new Random();

    public int generateRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }

    @Override
    public boolean isMovable() {
        return generateRandomNumber() >= MOVABLE_NUMBER_THRESHOLD;
    }
}
