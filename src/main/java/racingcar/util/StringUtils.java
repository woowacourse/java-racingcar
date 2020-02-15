package racingcar.util;

public class StringUtils {
    private static final String MESSAGE_NULL_OR_EMPTY = "잘못된 입력입니다.(Null or Empty)";

    public static String validNullOrEmpty(String input) {
        if (input == null || (input = input.trim()).isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_NULL_OR_EMPTY);
        }
        return input;
    }
}
