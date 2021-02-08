package racingcar.domain.car.util;

public interface MovingStrategy {
    int FORWARD_MOVEMENT_BOUNDARY_VALUE = 4;

    boolean canMove();
}
