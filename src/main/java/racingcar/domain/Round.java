package racingcar.domain;

import racingcar.exception.RacingCarErrorMessage;

public class Round {
    private static final int MIN_ROUND = 1;
    private final int round;

    public Round(final int round) {
        if (round < MIN_ROUND) {
            throw new IllegalStateException(RacingCarErrorMessage.ROUND_ONLY_NUMBER.message());
        }
        this.round = round;
    }

    public int get() {
        return round;
    }
}
