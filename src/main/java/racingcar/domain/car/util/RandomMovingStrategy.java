package racingcar.domain.car.util;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private final Random RANDOM = new Random();
    private final int END_EXCLUSIVE_NUMBER = 10;

    @Override
    public boolean canMove() {
        return RANDOM.nextInt(END_EXCLUSIVE_NUMBER) >= FORWARD_MOVEMENT_BOUNDARY_VALUE;
    }
}
