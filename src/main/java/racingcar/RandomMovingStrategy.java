package racingcar;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private final int MAXIMUM_VALUE = 10;
    private final Random random = new Random();

    @Override
    public int move() {
        return random.nextInt(MAXIMUM_VALUE);
    }
}
