package utils;

public class NumberValidator {

    private static final String NOT_INTEGER_MESSAGE = "[ERROR] 시도 횟수는 정수여야 합니다.";

    public static int parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE, e);
        }
    }
}
