package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

public class Rule {
    private RandomNumberGenerator randomGenerator;
    private int MIN_NUMBER = 0;
    private int MAX_NUMBER = 9;
    private int MOVE_LIMIT = 3;

    public boolean execute() {
        return generate() > MOVE_LIMIT;
    }

    private int generate() {
        return randomGenerator.generate(MIN_NUMBER, MAX_NUMBER);
    }
}
