package racingcar.domain;

public class Attempt {
    private final int attempt;

    public Attempt(int attempt) {
        if (isNegative(attempt)) {
            throw new IllegalArgumentException("시도횟수는 1이상의 수를 입력해주세요.");
        }
        this.attempt = attempt;
    }

    public Attempt(String attempt) {
        this(stringToInt(attempt));
    }
    
    public boolean isSame(int nowAttempt) {
        return attempt == nowAttempt;
    }

    @Override
    public String toString() {
        return "attempt : " + attempt;
    }

    private static int stringToInt(String text) {
        checkValid(text);
        return Integer.parseInt(text);
    }

    private static void checkValid(String attempt) {
        if (attempt.isBlank()) {
            throw new IllegalArgumentException("반복 횟수는 %s일 수 없습니다.");
        }
        if (!isNumber(attempt)) {
            throw new IllegalArgumentException("시도횟수는 숫자를 입력해주세요.");
        }
    }

    private static boolean isNumber(String string) {
        return string.matches("[+-]?\\d*(\\.\\d+)?");
    }

    private static boolean isNegative(int number) {
        return number <= 0;
    }
}
