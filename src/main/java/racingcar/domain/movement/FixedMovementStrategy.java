package racingcar.domain.movement;

public class FixedMovementStrategy implements MovementStrategy {

    private static final int DISTANCE = 1;

    @Override
    public int move() {
        return DISTANCE;
    }
}
