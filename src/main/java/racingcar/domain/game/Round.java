package racingcar.domain.game;

import racingcar.view.ErrorMessages;

public class Round {

    private static final int MINIMUM_POSITIVE_VALUE = 1;

    private final int value;
    private int played = 0;

    public Round(int value) {
        validateValue(value);
        this.value = value;
    }

    public Round(String value) {
        try {
            int parsedValue = Integer.parseInt(value);
            validateValue(parsedValue);
            this.value = parsedValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_ROUND_NOT_INTEGER);
        }
    }

    private void validateValue(int value) {
        if (value < MINIMUM_POSITIVE_VALUE) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_ROUND_NOT_POSITIVE);
        }
    }

    public boolean playRound() {
        if (!allRoundPlayed()) {
            ++played;
            return true;
        }
        return false;
    }

    public boolean allRoundPlayed() {
        return played == value;
    }

    public int getPlayed() {
        return played;
    }
}
