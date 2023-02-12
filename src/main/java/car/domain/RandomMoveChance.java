package car.domain;


import java.util.Random;

public class RandomMoveChance implements MoveChance {

    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MIN_MOVABLE_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return makeRandomNumber() < MIN_MOVABLE_NUMBER;
    }

    private int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
