package racingcar.domain.vo;

import racingcar.domain.enums.ErrorMessage;

public class Attempt {

    private static final int EMPTY_COUNT = 0;
    private static final int ZERO = 0;

    private int attempt;

    public Attempt(String attempt) {
        this.attempt = validate(attempt);
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

    private int validate(String attempt) {
        validateNumberFormat(attempt);
        int number = toInteger(attempt);
        validateNegative(number);
        return number;
    }

    private int toInteger(String string) {
        return Integer.parseInt(string);
    }

    private void validateNumberFormat(String attempt) {
        try {
            Integer.parseInt(attempt);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.get());
        }
    }

    private void validateNegative(int attempt) {
        if (attempt < ZERO) {
            throw new RuntimeException(ErrorMessage.NUMBER_NEGATIVE_ERROR_MESSAGE.get());
        }
    }
}
