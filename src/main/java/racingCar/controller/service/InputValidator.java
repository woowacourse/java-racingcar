package racingCar.controller.service;

import racingCar.domain.exception.NullInputException;

public class InputValidator {
    public static String validate(String input) {
        validateNotNullInput(input);
        return input;
    }

    private static void validateNotNullInput(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new NullInputException();
        }
    }
}