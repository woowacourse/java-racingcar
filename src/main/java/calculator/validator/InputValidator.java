package calculator.validator;

import java.util.List;

public class InputValidator {
    private static final String ZERO_OR_POSITIVE_INTEGER_REGEX = "^(0|[1-9][0-9]*)$";
    private static final String INVALID_POSITIVE_INTEGER_ERROR_MESSAGE = "양의 정수를 입력 해주세요.";

    public static void checkRightPositiveInteger(final List<String> inputNumbers) {
        inputNumbers.forEach(InputValidator::checkNumberStringException);
    }

    public static void checkNumberStringException(final String inputNumber) {
        if (!isZeroOrPositiveInteger(inputNumber)) {
            throw new RuntimeException(INVALID_POSITIVE_INTEGER_ERROR_MESSAGE);
        }
    }

    public static boolean isNullOrEmpty(final String input) {
        return input == null || input.isBlank();
    }

    public static boolean isZeroOrPositiveInteger(String input) {
        return input.matches(ZERO_OR_POSITIVE_INTEGER_REGEX);
    }
}
