package view;

import java.util.Objects;

public class InputValidater {

    public static final String DELIMITER = ",";

    public void validateCars(String input) {
        validateBlank(input);
        validateDuplicatedDelimiter(input);
        validateStartWord(input);
        validateEndWord(input);
    }

    private void validateEndWord(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("구분자로 끝날 수 없습니다.");
        }
    }

    private void validateStartWord(String input) {
        if (input.startsWith(DELIMITER)) {
            throw new IllegalArgumentException("구분자로 시작할 수 없습니다.");
        }
    }

    private void validateDuplicatedDelimiter(String input) {
        if (input.contains(DELIMITER.repeat(2))) {
            throw new IllegalArgumentException("올바른 형식으로 입력해주세요.");
        }
    }

    private void validateBlank(String input) {
        if (Objects.isNull(input) || input.isBlank())  {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    public void validateCount(String input) {
        validateBlank(input);
        validateNumeric(input);
        validateRange(input);
        validatePositive(input);
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
