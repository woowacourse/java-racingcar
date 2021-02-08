package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

public class RandomNumberRule implements RandomNumberRuleStrategy {
    int MIN_NUMBER = 0;
    int MAX_NUMBER = 9;

    public boolean execute() {
        return generate() > MOVE_LIMIT;
    }

    private int generate() {
        return RandomNumberGenerator.generate(MIN_NUMBER, MAX_NUMBER);
    }
}
