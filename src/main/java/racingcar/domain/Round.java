package racingcar.domain;

import java.util.Objects;

public class Round {
    private static final int MINIMUM_ROUND_NUMBER = 1;
    private static final int DECREASE_NUMBER = 1;

    private final int roundNum;

    private Round(int roundNum) {
        this.roundNum = roundNum;
    }

    public static Round fromNumber(int round) {
        return new Round(round);
    }

    public boolean isPositiveNumber() {
        return this.roundNum >= MINIMUM_ROUND_NUMBER;
    }

    public Round reduce() {
        return new Round(roundNum - DECREASE_NUMBER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Round)) {
            return false;
        }
        Round round = (Round) o;
        return roundNum == round.roundNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundNum);
    }
}
