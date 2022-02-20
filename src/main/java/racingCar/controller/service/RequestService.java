package racingCar.controller.service;

import racingCar.model.exception.NullInputException;
import racingCar.model.utlis.Util;
import racingCar.view.Input;

public class RequestService {
    public static String requestNames() {
        String input = Input.inputNames();
        validateNotNullInput(input);
        return input;
    }

    public static int requestCount() {
        String input = Input.inputCount();
        validateNotNullInput(input);
        return Util.convertToInteger(input);
    }

    private static void validateNotNullInput(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new NullInputException();
        }
    }
}