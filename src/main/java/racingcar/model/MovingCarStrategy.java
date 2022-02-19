package racingcar.model;

@FunctionalInterface
public interface MovingCarStrategy {
    boolean canMove();
}
