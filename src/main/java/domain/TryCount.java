package domain;

import common.exception.model.ValidateException;

public class TryCount {
    private int value;

    private static final int MIN_TRY_COUNT = 1;
    private static final int MAX_TRY_COUNT = 5;
    public static final String TRY_COUNT_RANGE_ERROR_MESSAGE = String.format("시도 횟수는 %d 이상, %d 이하여야 합니다", MIN_TRY_COUNT, MAX_TRY_COUNT);

    public TryCount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_TRY_COUNT || value > MAX_TRY_COUNT) {
            throw new ValidateException(TRY_COUNT_RANGE_ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }
}
