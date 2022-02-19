package racingcar.domain;

import java.util.Objects;

public class Round {
    private static final int END_ROUND_NUMBER = 0;
    private static final int MINIMUM_ROUND_NUMBER = 1;
    private static final int DECREASE_NUMBER = 1;

    private final int roundNum;

    private Round() {
        this.roundNum = END_ROUND_NUMBER;
    }

    private Round(final int roundNum) {
        validateMinimum(roundNum);
        this.roundNum = roundNum;
    }

    private static void validateMinimum(final int roundNum) {
        if (roundNum < MINIMUM_ROUND_NUMBER) {
            throw new IllegalArgumentException("시도 횟수의 최소값은 0 이하일 수 없습니다.");
        }
    }

    public static Round fromNumber(final int round) {
        return new Round(round);
    }

    public boolean isPositiveNumber() {
        return this.roundNum >= MINIMUM_ROUND_NUMBER;
    }

    public Round reduce() {
        if (roundNum == MINIMUM_ROUND_NUMBER) {
            return new Round();
        }
        return new Round(roundNum - DECREASE_NUMBER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Round))
            return false;
        Round round = (Round)o;
        return roundNum == round.roundNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundNum);
    }
}
