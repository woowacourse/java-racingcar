package utils;

public class NumberValidator {

    private static final String NOT_NUMBER_MESSAGE = "[ERROR] 반복횟수는 정수여야 합니다.";
    private static final String INVALID_NUMBER_MESSAGE = "[ERROR] 반복횟수는 0보다 커야 합니다.";

    public static int validate(final String input) {
        try {
            int number = Integer.parseInt(input);
            validateRange(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE, e);
        }
    }

    private static void validateRange(final int number) {
        if (number > 0) {
            return;
        }
        throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
    }
}
