package racingcar.util;

import racingcar.constant.ErrorLog;

public class Validator {

    private static final String EMPTY_STRING = "";

    public static void validateNotEmptyInput(String input) {
        if (input.trim().equals("")) {
            throw new IllegalArgumentException(ErrorLog.EMPTY_STRING.getMessage());
        }
    }
}
