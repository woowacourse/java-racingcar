package racingcar.domain;

import java.util.Objects;

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

    public TryNumber decreaseNumber() {
        return new TryNumber(tryNumber - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TryNumber tryNumber1 = (TryNumber) o;
        return tryNumber == tryNumber1.tryNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryNumber);
    }
}