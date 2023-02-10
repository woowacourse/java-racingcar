package util;

//TODO: validateCountRange매직넘버로 변경
public class Validator {
    private static final String CHARACTER_REG = "^[a-zA-Z]*$";

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
        if (count < 1) {
            throw new IllegalArgumentException("이동 횟수는 1이상의 숫자만 가능합니다.");
        }
    }
}
