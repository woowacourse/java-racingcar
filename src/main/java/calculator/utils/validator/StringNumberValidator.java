package calculator.utils.validator;

public class StringNumberValidator {
    private static final String ZERO_AND_POSITIVE_INTEGER_REGEX = "^(0|[1-9][0-9]*)$";
    private static final String INVALID_POSITIVE_INTEGER_ERROR_MESSAGE = "양의 정수를 입력 해주세요.";

    public static boolean validate(String stringNumber) {
        checkNumberStringException(stringNumber);
        return true;
    }

    private static void checkNumberStringException(String numberString) {
        if (!isPositiveInteger(numberString)) {
            throw new RuntimeException(INVALID_POSITIVE_INTEGER_ERROR_MESSAGE);
        }
    }

    private static boolean isPositiveInteger(String input) {
        return input.matches(ZERO_AND_POSITIVE_INTEGER_REGEX);
    }
}
