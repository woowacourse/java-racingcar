package racingcar.util;

public class IntegerUtils {
    private static final String MESSAGE_NOT_A_NUMBER = "숫자가 아닙니다";

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE_NOT_A_NUMBER);
        }
    }
}
