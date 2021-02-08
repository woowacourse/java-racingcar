package racingcar.domain;

public interface RandomNumberRuleStrategy {
    int MOVE_LIMIT = 3;

    boolean execute();
}
