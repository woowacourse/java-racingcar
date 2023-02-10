package utils;

import java.util.Random;

public class NormalRandomGenerator implements RandomGenerator {
    private final static int RANDOM_RANGE = 10;
    private final static int MOVE_STANDARD = 4;

    @Override
    public boolean movable() {
        return createRandomNumber() >= MOVE_STANDARD;
    }

    public int createRandomNumber() {
        return new Random().nextInt(RANDOM_RANGE);
    }
}
