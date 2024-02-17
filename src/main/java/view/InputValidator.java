package view;

public class InputValidator {
    public void validateCount(String input) {
        validateBlank(input);
        validateNumeric(input);
        validateRange(input);
        validatePositive(input);
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    private void validateRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정상적인 범위의 수를 입력해주세요.");
        }
    }

    private void validatePositive(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
    }

    private void validateNumeric(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
