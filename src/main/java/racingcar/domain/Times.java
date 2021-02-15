package racingcar.domain;

import java.util.Objects;

public class Times {
    public static final int LIMITATION = (int) 1e8;
    private static final int ZERO = 0;
    private static final String NON_POSITIVE_ERROR_MESSAGE = "[ERROR] 양수만 입력해 주세요: ";
    private static final String LIMITATION_ERROR_MESSAGE = "[ERROR] 한계값 이하만 입력해 주세요: ";

    private final int value;

    public Times(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        validatePositive(value);
        validateLimitation(value);
    }

    private void validatePositive(final int value) {
        if (value <= ZERO) {
            throw new IllegalArgumentException(NON_POSITIVE_ERROR_MESSAGE + value);
        }
    }

    private void validateLimitation(final int value) {
        if (value <= LIMITATION) {
            return;
        }
        throw new IllegalArgumentException(LIMITATION_ERROR_MESSAGE + value);
    }

    public Times reduce() {
        return new Times(value - 1);
    }

    public boolean isEnd() {
        return value < ZERO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Times times = (Times) o;
        return value == times.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Times{" +
                "value=" + value +
                '}';
    }
}
