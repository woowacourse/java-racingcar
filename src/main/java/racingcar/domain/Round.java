package racingcar.domain;

import racingcar.validator.RoundValidator;

public class Round {
    private static final int MIN_COUNT_SIZE = 1;
    private final int count;

    private Round(int count) {
        RoundValidator.validateRoundCount(count);
        this.count = count;
    }

    public static Round of(int count) {
        return new Round(count);
    }
}
