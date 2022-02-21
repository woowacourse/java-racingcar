package racingcar.domain;

import java.util.Objects;

public class Round {
    private static final int POSITIVE_NUMBER_STANDARD = 1;
    private static final String ERROR_INVALID_RANGE_MESSAGE = "정상 범위(" + POSITIVE_NUMBER_STANDARD + "이상)가 아닙니다";
    private static final int ROUND_END_NUMBER = 0;
    private static final int DECREASED_NUMBER = 1;

    private final int roundNum;

    private Round(int roundNum) {
        this.roundNum = roundNum;
    }

    public static Round fromInput(int inputRound) {
        validateRound(inputRound);
        return new Round(inputRound);
    }

    private static void validateRound(int inputRound) {
        checkValidRangeOfInputRound(inputRound);
    }

    private static void checkValidRangeOfInputRound(int inputRound) {
        if (inputRound < POSITIVE_NUMBER_STANDARD) {
            throw new IllegalArgumentException(ERROR_INVALID_RANGE_MESSAGE);
        }
    }

    public boolean isValidRound() {
        return this.roundNum > ROUND_END_NUMBER;
    }

    public Round toNextRound() {
        return new Round(roundNum - DECREASED_NUMBER);
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
