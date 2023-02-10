package util;

public class Validator {
    private static final String CHARACTER_REG = "^[a-zA-Z]*$";
    private static final int MOVING_COUNT_MIN_RANGE = 1;
    private static final int MOVING_COUNT_MAX_RANGE = 100;

    public static void validateMovingCountInput(String input) {
        validateIsDigit(input);
        validateCountRange(Integer.parseInt(input));
    }

    private static void validateIsDigit(String input) {
        if (input.matches(CHARACTER_REG)) {
            throw new IllegalArgumentException("이동할 횟수는 숫자만 입력 가능합니다.");
        }
    }

    private static void validateCountRange(Integer count) {
        if (count < MOVING_COUNT_MIN_RANGE || count > MOVING_COUNT_MAX_RANGE) {
            throw new IllegalArgumentException("이동 횟수는 1이상, 100이하의 숫자만 가능합니다.");
        }
    }
}
