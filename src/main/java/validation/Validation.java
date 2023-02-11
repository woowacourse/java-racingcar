package validation;

import constant.ExceptionMessage;

public class Validation {
    private final int MIN_TRY_COUNT_INPUT = 1;

    public void validateCarNames(String carNames) throws IllegalAccessException {
        if (carNames.isEmpty()) {
            throw new IllegalAccessException(
                    ExceptionMessage.CAR_NAME_NOT_INPUT_MESSAGE.getExceptionMessage());
        }

        if (carNames.isBlank()) {
            throw new IllegalAccessException(
                    ExceptionMessage.CAR_NAME_BLANK_MESSAGE.getExceptionMessage());
        }
    }

    public void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT_INPUT) {
            throw new IllegalArgumentException(
                    ExceptionMessage.TRY_COUNT_NOT_POSITIVE_MESSAGE.getExceptionMessage());
        }
    }
}
