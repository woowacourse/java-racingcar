package car.domain;

import static car.option.Option.MIN_MOVABLE_NUMBER;

import java.util.Random;

public class RandomMoveChance implements MoveChance {

    private static final int BOUND = 10;


    @Override
    public boolean isMovable() {
        return makeRandomNumber() < MIN_MOVABLE_NUMBER;
    }

    private int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }
}
