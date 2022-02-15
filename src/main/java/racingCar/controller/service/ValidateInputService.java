package racingCar.controller.service;

import racingCar.model.exception.NullInputException;

public class ValidateInputService {
    public static String request(String input) {
        validateNotNullInput(input);
        return input;
    }

    private static void validateNotNullInput(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new NullInputException();
        }
    }
}