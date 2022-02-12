package calculator.utils;

import java.util.List;

public class CalculatorInputValidator {
    public static final String ERROR_NUMBER_RIGHT_FORMAT = "[error] 숫자를 입력해주세요.";
    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";
    private static final int NUMBER = 0;

    private CalculatorInputValidator() {
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
        numbers.forEach(CalculatorInputValidator::checkValidateNumber);
    }

    private static void checkValidateNumber(String number) {
        if (isRightNumber(number)) {
            return;
        }
        throw new IllegalArgumentException(ERROR_NUMBER_RIGHT_FORMAT);
    }

    private static boolean isRightNumber(String number) {
        if (number.equals(COMMA_DELIMITER) || number.equals(COLON_DELIMITER)) {
            return true;
        }
        return Character.isDigit((number.charAt(NUMBER)));
    }
}
