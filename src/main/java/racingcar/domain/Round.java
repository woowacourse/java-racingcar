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

    public boolean moreThanZero() {
        return this.roundNum > ZERO;
    }

    public Round hasNext() {
        return new Round(roundNum - ONE);
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
