package racingcar.util;

public class NumberValidator {
    private static final String NUMBER_PATTERN = "[-]?[0-9]+";

    public static void validateStringIsNumber(String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("입력은 숫자여야 합니다.");
        }
    }
}
