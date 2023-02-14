package utils;

public class IntegerParser {

    private static final String NOT_INTEGER_MESSAGE = "[ERROR] 입력 값은 정수여야 합니다.";

    public static int parse(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE, e);
        }
    }
}
