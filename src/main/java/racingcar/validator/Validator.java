package racingcar.validator;

public class Validator {
    public static void attempt(String attempt) {
        if (attempt.isBlank()) {
            throw new IllegalArgumentException("반복 횟수는 %s일 수 없습니다.");
        }
        if (!isNumber(attempt)) {
            throw new IllegalArgumentException("시도횟수는 숫자를 입력해주세요.");
        }
        if (isNegative(attempt)) {
            throw new IllegalArgumentException("시도횟수는 1이상의 수를 입력해주세요.");
        }
    }

    private static boolean isNumber(String string) {
        return string.matches("[+-]?\\d*(\\.\\d+)?");
    }

    private static boolean isNegative(String string) {
        int attempt = Integer.parseInt(string);
        return attempt <= 0;
    }
}
