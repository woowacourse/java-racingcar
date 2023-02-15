package racingcar.service;

import java.util.Random;
import racingcar.domain.Car;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_NUMBER_BOUNDARY = 10;

    @Override
    public boolean isMovable() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUNDARY) >= Car.FORWARD_BOUNDARY;
    }
}
