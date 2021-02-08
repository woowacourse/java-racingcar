package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

public class CarMoveRule implements CarMoveRuleStrategy {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MOVE_LIMIT = 3;

    public boolean execute() {
        return generate() > MOVE_LIMIT;
    }

    private int generate() {
        return RandomNumberGenerator.generate(MIN_NUMBER, MAX_NUMBER);
    }
}
