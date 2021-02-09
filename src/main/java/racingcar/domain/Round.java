package racingcar.domain;

import racingcar.validator.RoundValidator;

public class Round {
    private final int count;

    private Round(String inputCount) {
        this.count = Integer.parseInt(inputCount);
    }

    public static Round of(String inputCount) {
        RoundValidator.validate(inputCount);
        return new Round(inputCount);
    }

    public int getCount() {
        return this.count;
    }
}
