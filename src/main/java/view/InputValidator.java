package view;

public class InputValidator {
    private static final String BLANK_ERROR_MESSAGE = "경주할 자동차 이름에 대한 입력은 공백일 수 없습니다.";

    public static void validateCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }
}
