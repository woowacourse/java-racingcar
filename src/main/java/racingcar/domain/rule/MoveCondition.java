package racingcar.domain.rule;

@FunctionalInterface
public interface MoveCondition {
    boolean isMovable();
}