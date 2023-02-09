package car.domain;

import static car.option.Option.MIN_MOVABLE_NUMBER;

import java.util.Random;

public class RandomMoveChance implements MoveChance {

    @Override
    public boolean isMovable() {
        return makeRandomNumber() < MIN_MOVABLE_NUMBER;
    }

    private int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
