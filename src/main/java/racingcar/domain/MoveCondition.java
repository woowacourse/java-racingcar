package racingcar.domain;

@FunctionalInterface
public interface MoveCondition {
    boolean isMovable(int t);
}
