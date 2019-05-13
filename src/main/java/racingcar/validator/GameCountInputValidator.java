package racingcar.validator;

public class GameCountInputValidator {
    private GameCountInputValidator() {
    }

    public static void checkAccuracyOfGameCount(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException("게임 횟수는 정수로 입력해 주세요.");
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
