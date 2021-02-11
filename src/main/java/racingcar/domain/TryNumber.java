package racingcar.domain;

public class TryNumber {

    private static final int MIN_ATTEMPT_NUMBER = 1;
    private static final String ERROR_MESSAGE = "시도 횟수는 1회 이상이여야 합니다.";

    private final int tryNumber;

    public TryNumber(final int tryNumber) {
        validateNumberRange(tryNumber);
        this.tryNumber = tryNumber;
    }

    private void validateNumberRange(final int tryNumber) {
        if (tryNumber < MIN_ATTEMPT_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public int getTryNumber() {
        return tryNumber;
    }
}