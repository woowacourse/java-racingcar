package racingcar.util;

import static racingcar.view.ErrorMessage.*;

public class Validator {

    private static final int MINIMUM_TIME = 0;
    private static final String BLANK = "";
    private static final int MAXIMUM_LENGTH = 5;

    private Validator() {
    }

    public static void validateCarNames(String carName) {
        validateCarNameLength(carName);
        validateNoInput(carName);
    }

    public static int validateGameTime(int input) {
        validateGameTimeRange(input);
        return input;
    }

    private static void validateGameTimeRange(int inputNumber) {
        if (inputNumber <= MINIMUM_TIME) {
            throw new IllegalArgumentException(ERROR_PREFIX + NOT_POSITIVE_NUMBER);
        }
    }

    public static int validateStringToInt(String input) {
        Integer integer;
        try {
            integer = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + NOT_NUMBER);
        }
        return integer;
    }

    private static void validateNoInput(String carName) {

        if (carName.equals(BLANK)) {
            throw new IllegalArgumentException(ERROR_PREFIX + NO_INPUT);
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() >= MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + CAR_NAME_LENGTH);
        }
    }
}
