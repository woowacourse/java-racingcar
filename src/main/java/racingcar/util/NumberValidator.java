package racingcar.util;

public class NumberValidator {
    private static final int POSITIVE_STANDARD = 0;
    private static final String NUMBER_PATTERN = "[-]?[0-9]+";

    public static void validateStringIsNumber(final String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("입력은 숫자여야 합니다.");
        }
    }

    public static void validateIsPositive(final int input) {
        if (input <= POSITIVE_STANDARD) {
            throw new IllegalArgumentException("숫자는 양수여야 합니다.");
        }
    }

    public static void validateIsNotNegative(final int input) {
        if (input < POSITIVE_STANDARD) {
            throw new IllegalArgumentException("숫자는 음수일 수 없습니다.");
        }
    }
}
