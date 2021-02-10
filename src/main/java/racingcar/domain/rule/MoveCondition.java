package racingcar.domain.rule;

public interface MoveCondition<T> {
    T generate(int bound);
}