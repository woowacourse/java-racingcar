package racingcar.service;

import racingcar.domain.Car;

public class FixedMoveStrategy implements MoveStrategy {
    private final int number;

    public FixedMoveStrategy(int number) {
        this.number = number;
    }

    @Override
    public boolean isMovable() {
        return number >= Car.FORWARD_BOUNDARY;
    }
}
