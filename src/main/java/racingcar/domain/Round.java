package racingcar.domain;

import java.util.Objects;

public class Round {
    public static final int INIT_ROUND = 0;
    public static final String INVALID_NUMBER_OF_ROUNDS_MESSAGE = "[ERROR] 라운드 횟수는 0 이상이어야 합니다";
    public static final String NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 숫자 (정수)를 입력해 주세요.";

    private int round;

    public Round() {
        this.round = INIT_ROUND;
    }

    public Round(String round) {
        validateIntegerNumber(round);
        validateNonNegativeNumber(round);
        this.round = Integer.parseInt(round);
    }

    public static void validateIntegerNumber(String numberOfRoundsInput) {
        try {
            Integer.parseInt(numberOfRoundsInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    public static void validateNonNegativeNumber(String numberOfRounds) {
        if (Integer.parseInt(numberOfRounds) < INIT_ROUND) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_ROUNDS_MESSAGE);
        }
    }

    public void increase() {
        round++;
    }

    public int getRound() {
        return round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round1 = (Round) o;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}