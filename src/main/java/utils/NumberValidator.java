package utils;

public class NumberValidator {

    private static final String NOT_NUMBER_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 합니다.";

    public static int parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE, e);
        }
    }
}
