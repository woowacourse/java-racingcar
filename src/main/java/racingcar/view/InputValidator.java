package racingcar.view;

public class InputValidator {
    private static final String BLANK_EXCEPTION_MESSAGE = "입력은 공백일 수 없습니다.";

    public static void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }
}
