package racingcar.domain.game;

import racingcar.view.ErrorMessages;

public class Round {

    private static final int MINIMUM_POSITIVE_VALUE = 1;

    private final int value;
    private int played = 0;

    public Round(int value) {
        if (value < MINIMUM_POSITIVE_VALUE) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_ROUND_NOT_POSITIVE);
        }
        this.value = value;
    }

    public Round(String value) {
        try {
            this.value = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_ROUND_NOT_INTEGER);
        }
    }

    public void playRound() {
        ++played;
    }

    public boolean allRoundPlayed() {
        return played == value;
    }

    public int getPlayed() {
        return played;
    }
}
