package racingcar.util;

import racingcar.Car;
import racingcar.view.ErrorMessage;

import java.util.Arrays;

import static racingcar.view.ErrorMessage.*;

public class Validator {

    private static final String DELIMITER = ",";

    private Validator() {
    }

    public static void validateCarNames(String carName) {
        validateCarNameLength(carName);
        validateNoInput(carName);
    }

    public static int validateGameTime(String input) {
        int inputNumber = validateStringToInt(input);
        validateGameTimeRange(inputNumber);
        return inputNumber;
    }

    private static void validateGameTimeRange(int inputNumber) {
        if (inputNumber <= 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + NOT_POSITIVE_NUMBER);
        }
    }

    private static int validateStringToInt(String input) {
        Integer integer = null;
        try {
            integer = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + NOT_NUMBER);
        }
        return integer;
    }

    private static void validateNoInput(String carName) {

        if (carName.equals("")) {
            throw new IllegalArgumentException(ERROR_PREFIX + NO_INPUT);
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() >= 5) {
            throw new IllegalArgumentException(ERROR_PREFIX + CAR_NAME_LENGTH);
        }
    }
}
