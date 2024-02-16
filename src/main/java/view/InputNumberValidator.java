package view;

public class InputNumberValidator {

    public static final String NOT_NUMBER = "시도 횟수가 숫자가 아닙니다.";
    public static final String NOT_POSITIVE_NUMBER = "시도 횟수가 양수가 아닙니다.";


    public static void validatePositiveNumber(String number) {
        int validateNumber = validateNumber(number);
        validatePositive(validateNumber);
    }

    private static int validateNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    private static void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER);
        }
    }
}
