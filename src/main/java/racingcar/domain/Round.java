package racingcar.domain;

import java.util.Objects;
import racingcar.util.Validator;

public class Round {
    private static final int ROUND_END_NUMBER = 0;
    private static final int DECREASED_NUMBER = 1;
    private final int roundNum;

    public Round(String roundNum) {
        this.roundNum = Integer.parseInt(roundNum);
        Validator.validateRound(roundNum);
    }

    public boolean isValidRound() {
        return this.roundNum > ROUND_END_NUMBER;
    }

    public Round toNextRound() {
        return new Round(String.valueOf(roundNum - DECREASED_NUMBER));
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Round)) {
            return false;
        }
        Round round = (Round) object;
        return roundNum == round.roundNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundNum);
    }
}
