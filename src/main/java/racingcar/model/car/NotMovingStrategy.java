package racingcar.model.car;

public class NotMovingStrategy implements MovingStrategy {
    @Override
    public boolean movable() {
        return false;
    }
}
