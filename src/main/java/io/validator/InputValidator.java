package io.validator;


import java.util.regex.Pattern;

public class InputValidator {
    private static final String CAR_NAMES_REGEX = "[가-힣a-zA-Z]{2,5}(,[가-힣a-zA-Z]{2,5})*";
    private static final Pattern CAR_NAMES_PATTERN = Pattern.compile(CAR_NAMES_REGEX);

    public void validateIntFormat(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    public void validateCarNamesFormat(String carNames) {
        if(CAR_NAMES_PATTERN.matcher(carNames).matches()) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
