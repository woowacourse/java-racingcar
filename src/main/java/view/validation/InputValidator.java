package view.validation;

public class InputValidator {
    private static final String COMMA = ",";

    private InputValidator() {
    }

    public static void validateComma(String input) {
        if (!input.contains(COMMA)) {
            throw new IllegalArgumentException("자동차 이름은 쉼표로 구분하여 입력해야 합니다.");
        }
    }
}
