package racingcar.domain.car.util;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final Random RANDOM = new Random();
    private static final int END_EXCLUSIVE_NUMBER = 10;

    @Override
    public boolean canMove() {
        return RANDOM.nextInt(END_EXCLUSIVE_NUMBER) >= FORWARD_MOVEMENT_BOUNDARY_VALUE;
    }
}
