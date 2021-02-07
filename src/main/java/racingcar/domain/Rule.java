package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

public class Rule implements RuleStrategy {
    public boolean execute() {
        return generate() > MOVE_LIMIT;
    }

    private int generate() {
        return RandomNumberGenerator.generate(MIN_NUMBER, MAX_NUMBER);
    }
}
