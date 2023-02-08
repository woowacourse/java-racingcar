package racingcar.util;

public class Validator {

    private static final String EMPTY_STRING = "";

    public static void validateNotEmptyInput(String input) {
        if (input.trim().equals("")) {
            throw new IllegalArgumentException();
        }
    }
}
