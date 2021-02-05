package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

public class Rule implements RuleStrategy {
    private RandomNumberGenerator randomGenerator;

    public boolean execute() {
        return generate() > MOVE_LIMIT;
    }

    private int generate() {
        return randomGenerator.generate(MIN_NUMBER, MAX_NUMBER);
    }
}
