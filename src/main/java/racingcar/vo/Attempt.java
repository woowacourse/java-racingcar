package racingcar.vo;

import racingcar.view.ErrorMessage;

public class Attempt {

    private static final int EMPTY_COUNT = 0;
    private static final int ZERO = 0;

    private int attempt;

    public Attempt(String attempt) {
        this.attempt = valid(attempt);
    }

    public int getAttempt() {
        return attempt;
    }

    public boolean isLeft() {
        return attempt > EMPTY_COUNT;
    }

    public void decrease() {
        attempt--;
    }

    private int valid(String attempt) {
        int number = toInteger(attempt);
        validateNegative(number);
        return number;
    }

    private int toInteger(String attempt) {
        return Integer.parseInt(attempt);
    }

    private void validateNegative(int attempt) {
        if (attempt < ZERO) {
            throw new RuntimeException(ErrorMessage.NUMBER_NEGATIVE.toString());
        }
    }
}
