package racingcar;

public class TryCountParser {

    public int parse(String input) {
        validateTryCount(input);
        return Integer.parseInt(input);
    }

    private void validateTryCount(String input) {
        if (isFloat(input)) {
            throw new IllegalArgumentException("시도 횟수는 실수가 될 수 없습니다.");
        }
        if (isNegative(input)) {
            throw new IllegalArgumentException("시도 횟수는 음수가 될 수 없습니다.");
        }
        if (isZero(input)) {
            throw new IllegalArgumentException("시도 횟수는 0이 될 수 없습니다.");
        }
    }

    private boolean isFloat(String input) {
        return input.matches("(-|\\+)?[0-9]+\\.[0-9]+");
    }

    private boolean isNegative(String input) {
        return Integer.parseInt(input) < 0;
    }

    private boolean isZero(String input) {
        return Integer.parseInt(input) == 0;
    }
}
