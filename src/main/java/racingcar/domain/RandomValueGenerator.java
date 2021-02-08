package racingcar.domain;

import java.util.Random;

public class RandomValueGenerator implements MoveValueStrategy{
    private static final int BOUND = 10;

    private final Random random = new Random();

    @Override
    public int createMoveValue() {
        return random.nextInt(BOUND);
    }
}
