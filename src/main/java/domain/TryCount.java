package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidateException;

public class TryCount {
    private final int value;

    public static final int MIN_TRY_COUNT = 1;
    public static final int MAX_TRY_COUNT = 5;

    public TryCount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_TRY_COUNT || value > MAX_TRY_COUNT) {
            throw new ValidateException(ExceptionMessage.TRY_COUNT_RANGE_ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }
}
