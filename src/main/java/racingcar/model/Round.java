package racingcar.model;

import racingcar.message.ErrorMessage;

public class Round {

    private int value;

    private Round(int value) {
        this.value = value;
    }

    public static Round from(final String source) {
        final int value = parseInt(source);
        if (value < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND.get());
        }
        return new Round(value);
    }

    private static int parseInt(String source) {
        try {
            return Integer.parseInt(source);
        }  catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND.get());
        }
    }

    public boolean isContinue() {
        return value > 0;
    }

    public void progress() {
        if (!isContinue()) {
            throw new IllegalStateException(ErrorMessage.INVALID_ROUND.get());
        }
        value--;
    }
}
