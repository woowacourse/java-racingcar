package racingcar.domain;

import java.util.Objects;

public class Round {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private final int roundNum;

    public Round(int roundNum) {
        this.roundNum = roundNum;
    }

    public static Round from(int round) {
        return new Round(round);
    }

    public boolean hasNext() {
        return roundNum-- > ZERO;
    }
}
