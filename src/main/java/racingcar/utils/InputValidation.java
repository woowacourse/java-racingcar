package racingcar.utils;

import racingcar.utils.exception.*;

import java.util.regex.Pattern;

public class InputValidation {
    private InputValidation() {
    }

    public static void validateTime(String input) {
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, input) || input.equals("0")) {
            throw new InvalidTimeException();
        }
    }
}
