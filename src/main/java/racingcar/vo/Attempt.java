package racingcar.vo;

import racingcar.view.ErrorMessage;

public class Attempt {

    private static final int EMPTY_COUNT = 0;
    private static final int ZERO = 0;
    private static final int DECREASE_ONT_TIME = 1;

    private final int attempt;

    public Attempt(String attemptInput) {
        int number = toInteger(attemptInput);
        validateNegative(number);
        this.attempt = number;
    }

    private Attempt(int attempt) {
        this.attempt = attempt;
    }

    public boolean isLeft() {
        return attempt > EMPTY_COUNT;
    }

    public Attempt decrease() {
        return new Attempt(attempt - DECREASE_ONT_TIME);
    }

    private int toInteger(String attempt) {
        return Integer.parseInt(attempt);
    }

    private void validateNegative(int attempt) {
        if (attempt < ZERO) {
            throw new RuntimeException(ErrorMessage.NUMBER_NEGATIVE.getMessage());
        }
    }

    public int getAttempt() {
        return attempt;
    }
}
