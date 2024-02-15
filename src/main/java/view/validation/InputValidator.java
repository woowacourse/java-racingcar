package view.validation;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String COMMA = ",";
    private static final int MIN_TRY_COUNT = 1;
    private static final Pattern IS_DIGIT = Pattern.compile("^[0-9]*$");

    private InputValidator() {
    }

    public static void validateCarNames(String input) {
        validateComma(input);
        validateEndsWithComma(input);
    }

    private static void validateComma(String input) {
        if (!input.contains(COMMA)) {
            throw new IllegalArgumentException("자동차 이름은 쉼표로 구분하여 입력해야 합니다.");
        }
    }

    private static void validateEndsWithComma(String input) {
        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException("자동차 이름은 쉼표로 끝날 수 없습니다.");
        }
    }

    public static void validateTryCount(String input) {
        validateIsDigit(input);
        validateMinTryCount(input);
    }

    private static void validateIsDigit(String input) {
        if (!IS_DIGIT.matcher(input).matches()) {
            throw new IllegalArgumentException("시도 횟수는 숫자이어야 합니다.");
        }
    }

    private static void validateMinTryCount(String input) {
        if (Integer.parseInt(input) < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다.");
        }
    }
}
