package racingcar.vo;

import racingcar.view.ErrorMessage;

public class Attempt {

    private static final int EMPTY_COUNT = 0;
    private static final int ZERO = 0;

    private int attempt;

    public Attempt(String attempt) {
        this.attempt = valid(attempt);
    }

    public int get() {
        return attempt;
    }

    public boolean isLeft() {
        return attempt > EMPTY_COUNT;
    }

    public void decrease() {
        attempt--;
    }

    private int valid(String attempt) {
        validNumberFormat(attempt);
        int number = toInteger(attempt);
        validNegative(number);
        return number;
    }

    private int toInteger(String string) {
        return Integer.parseInt(string);
    }

    private void validNumberFormat(String attempt) {
        try {
            Integer.parseInt(attempt);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException(ErrorMessage.NUMBER_FORMAT.toString());
        }
    }

    private void validNegative(int attempt) {
        if (attempt < ZERO) {
            throw new RuntimeException(ErrorMessage.NUMBER_NEGATIVE.toString());
        }
    }
}
