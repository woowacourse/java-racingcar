package domain;

import exception.ErrorMessage;
import exception.RacingCarGameException;

public class Count {
    private static final int COUNT_LOWER_BOUND = 1;
    private final int value;

    public Count(int value) {
        validatePositive(value);
        this.value = value;
    }

    public static Count from(int value) {
        return new Count(value);
    }

    private void validatePositive(int count) {
        if (count < COUNT_LOWER_BOUND) {
            throw RacingCarGameException.from(ErrorMessage.INVALID_COUNT_ERROR);
        }
    }

    public int getValue() {
        return value;
    }
}
