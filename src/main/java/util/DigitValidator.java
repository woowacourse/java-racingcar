package util;

import java.util.regex.Pattern;

public class DigitValidator {
    private static final Pattern IS_DIGIT = Pattern.compile("^\\d+$");

    private DigitValidator() {}

    public static void validateIsDigit(String input) {
        if (!IS_DIGIT.matcher(input).matches()) {
            throw new IllegalArgumentException("입력은 숫자이어야 합니다.");
        }
    }
}
