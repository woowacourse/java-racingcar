package domain;

public class AttemptNumber {
    private static final String NOT_INTEGER_MESSAGE = "정수가 아닙니다.";
    private static final String NOT_POSITIVE_MESSAGE = "양수가 아닙니다.";
    private static final String OVER_ATTEPT_NUMBER = "시도 횟수를 초과했습니다.";
    private static final int MIN_ATTEMPT_NUMBER = 1;

    private int number;

    public AttemptNumber(String number) {
        validateInteger(number);
        validatePositive(number);
        this.number = Integer.parseInt(number);
    }

    public void validateInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
        }
    }

    public void validatePositive(String number) {
        if (Integer.parseInt(number) < MIN_ATTEMPT_NUMBER) {
            throw new IllegalArgumentException(NOT_POSITIVE_MESSAGE);
        }
    }

    public boolean reduce() {
        if (this.number > 0) {
            this.number--;
            return true;
        }
        throw new IllegalArgumentException(OVER_ATTEPT_NUMBER);
    }

    public boolean isEnd() {
        return this.number <= 0;
    }
}
