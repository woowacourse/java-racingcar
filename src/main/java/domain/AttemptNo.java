package domain;

public class AttemptNumber {
    private static final String NOT_INTEGER_MESSAGE = "정수가 아닙니다.";
    private static final String NOT_POSITIVE_MESSAGE = "양수가 아닙니다.";
    private static final int MIN_ATTEMPT_NUMBER = 1;

    private int number;

    public AttemptNumber(final String number) {
        validateInteger(number);
        validatePositive(number);
        this.number = Integer.parseInt(number);
    }

    private void validateInteger(final String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
        }
    }

    private void validatePositive(final String number) {
        if (Integer.parseInt(number) < MIN_ATTEMPT_NUMBER) {
            throw new IllegalArgumentException(NOT_POSITIVE_MESSAGE);
        }
    }

    public boolean isEnd() {
        if (this.number >= MIN_ATTEMPT_NUMBER) {
            this.number--;
            return true;
        }
        return false;
    }
}
