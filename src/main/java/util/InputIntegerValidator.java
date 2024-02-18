package util;

public class InputIntegerValidator extends InputValidator {
    @Override
    void validateCustom(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
