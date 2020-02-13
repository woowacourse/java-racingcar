package racingcar.view;

public class ValidateInput {
    public static final int GAME_COUNT_MINIMUM = 0;

    public static void isBlank(String input) {
        if (input.replace(" ", "").isEmpty()) {
            throw new IllegalArgumentException("공백이 입력되었습니다.");
        }
    }

    public static void isNotNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("시도 횟수는 숫자를 입력해주세요.");
        }
    }

    public static void isNotPositiveNumber(int input) {
        if (input < GAME_COUNT_MINIMUM) {
            throw new IllegalArgumentException("시도 횟수는 양수만 입력해주세요.");
        }
    }
}
