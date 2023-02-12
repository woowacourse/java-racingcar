package racingcar.domain;

import java.util.Random;

public class RandomBasedMovement implements Movement {

    private static final int MINIMUM_MOVABLE_NUMBER = 4;
    private static final int RANGE_OF_RANDOM_NUMBER = 10;
    
    @Override
    public boolean isMovable() {
        return getRandom() >= MINIMUM_MOVABLE_NUMBER;
    }

    private static int getRandom() {
        return new Random().nextInt(RANGE_OF_RANDOM_NUMBER);
    }
}
