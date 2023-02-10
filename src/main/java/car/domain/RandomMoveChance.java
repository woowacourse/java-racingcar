package car.domain;

import java.util.Random;

public class RandomMoveChance implements MoveChance {

    private static final Random RANDOM = new Random();
    private static final int MIN_MOVABLE_NUMBER = 4;
    private static final int RANDOM_NUMBER_BOUNDARY = 10;

    @Override
    public boolean isMovable() {
        return makeRandomNumber() < MIN_MOVABLE_NUMBER;
    }

    private int makeRandomNumber() {
        return RANDOM.nextInt(RANDOM_NUMBER_BOUNDARY);
    }
}
