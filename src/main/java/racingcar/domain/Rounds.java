package racingcar.domain;

import racingcar.validator.RoundValidator;

public class Rounds {
    private int round;

    private Rounds(final int round) {
        RoundValidator.checkIsValid(round);
        this.round = round;
    }

    public static Rounds create(final int inputNumber) {
        return new Rounds(inputNumber);
    }

    public void next() {
        this.round--;
    }

    public boolean isEnd() {
        return this.round <= 0;
    }
}
