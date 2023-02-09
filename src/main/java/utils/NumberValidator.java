package utils;

public class NumberValidator {


    private static final String NOT_NUMBER_MESSAGE = "[ERROR] 반복횟수는 숫자여야 합니다.";

    public static int validate(String input) {
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE, e);
        }
    }
}
