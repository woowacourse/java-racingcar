package racingcar.util;

import racingcar.constant.ErrorLog;

public class Validator {

    public static final String NATURAL_NUMBER_REGEX = "^[1-9]+[0-9]*$";
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateNotEmptyInput(String str) {
        if (str == null || str.trim().isBlank()) {
            throw new IllegalArgumentException(ErrorLog.EMPTY_STRING.getMessage());
        }
    }

    public static void validateNaturalNumber(String str) {
        if (!str.matches(NATURAL_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorLog.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    public static void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorLog.INVALID_NAME_LENGTH.getMessage());
        }
    }
}
