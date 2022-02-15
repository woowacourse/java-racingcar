package racingCar.controller.service;

import racingCar.model.exception.NullInputException;
import racingCar.model.utils.Util;

public class RequestService {
    public static String requestNames(String input) {
        validateNotNullInput(input);
        return input;
    }

    public static int requestCount(String input) {
        validateNotNullInput(input);
        return Util.convertToInteger(input);
    }

    private static void validateNotNullInput(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new NullInputException();
        }
    }
}