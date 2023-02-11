package racingcar.model.car.strategy;

public class NotMovingStrategy implements MovingStrategy {
    @Override
    public boolean movable() {
        return false;
    }
}
