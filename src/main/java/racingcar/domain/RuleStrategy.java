package racingcar.domain;

public interface RuleStrategy {
    int MIN_NUMBER = 0;
    int MAX_NUMBER = 9;
    int MOVE_LIMIT = 3;

    boolean execute();
}
