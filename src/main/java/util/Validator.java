package util;

public class Validator {
    private static final String CHARACTER_REG = "^[a-zA-Z]*$";

    public static void validateMovingCountInput(String input) {
        if (hasCharacter(input)) {
            throw new IllegalArgumentException("이동할 횟수는 숫자만 입력 가능합니다.");
        }
    }

    private static boolean hasCharacter(String input) {
        return input.matches(CHARACTER_REG);
    }
}
