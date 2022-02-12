package racingcar.domain;

import java.util.Objects;

public class Round {
    private static final int ROUND_END_NUMBER = 0;
    private static final int DECREASED_NUMBER = 1;
    private final int roundNum;

    public Round(int roundNum) {
        this.roundNum = roundNum;
    }

    public static Round from(int round) {
        return new Round(round);
    }

    public boolean moreThanZero() {
        return this.roundNum > ROUND_END_NUMBER;
    }

    public Round hasNext() {
        return new Round(roundNum - DECREASED_NUMBER);
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
