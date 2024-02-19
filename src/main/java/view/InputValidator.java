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
            throw new IllegalArgumentException(String.format("입력된 값: %s, 공백을 입력할 수 없습니다.", input));
        }
    }

    private void validateRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("입력된 값: %s, 정상적인 범위의 수를 입력해주세요.", input));
        }
    }

    private void validatePositive(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(String.format("입력된 값: %s, 양수를 입력해주세요.", input));
        }
    }

    private void validateNumeric(String input) {
        if (isNumeric(input)) {
            throw new IllegalArgumentException(String.format("입력된 값: %s, 숫자를 입력해주세요.", input));
        }
    }

    private static boolean isNumeric(String input) {
        return !input.matches("-?\\d+");
    }
}
