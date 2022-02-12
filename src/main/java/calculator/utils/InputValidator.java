package calculator.utils;

import java.util.List;

public class InputValidator {
    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";
    private static final int NUMBER = 0;

    private InputValidator() {
    }

    public static boolean isInputNullOrBlankOrEmpty(String input) {
        return isNullInput(input) || isEmptyInput(input) || isBlankInput(input);
    }

    private static boolean isBlankInput(String input) {
        return input.isBlank();
    }

    private static boolean isEmptyInput(String input) {
        return input.isEmpty();
    }

    private static boolean isNullInput(String input) {
        return input == null;
    }

    public static void checkValidateNumbers(List<String> numbers) {
        numbers.forEach(InputValidator::checkValidateNumber);
    }

    private static void checkValidateNumber(String number) {
        if (isRightNumber(number)) {
            return;
        }
        throw new RuntimeException();
    }

    private static boolean isRightNumber(String number) {
        if (number.equals(COMMA_DELIMITER) || number.equals(COLON_DELIMITER)) {
            return true;
        }
        return Character.isDigit((number.charAt(NUMBER)));
    }
}
