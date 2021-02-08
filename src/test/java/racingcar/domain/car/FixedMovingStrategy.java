package racingcar.domain.car;

import racingcar.domain.car.util.MovingStrategy;

public class FixedMovingStrategy implements MovingStrategy {
    int number;

    public FixedMovingStrategy(int number) {
        this.number = number;
    }

    @Override
    public boolean canMove() {
        return number >= FORWARD_MOVEMENT_BOUNDARY_VALUE;
    }
}
