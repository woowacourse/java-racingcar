package racingcar.parser;

import racingcar.parser.exception.TryCountBlankException;

public class TryCountParser {

    public int parse(String input) {
        validateTryCount(input);
        return Integer.parseInt(input);
    }

    private void validateTryCount(String input) {
        if (isBlankTryCount(input)) {
            throw new TryCountBlankException();
        }
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

    private boolean isBlankTryCount(String input) {
        return input.isBlank();
    }

    private boolean isFloatTryCount(String input) {
        return input.matches("(-|\\+)?[0-9]+\\.[0-9]+");
    }

    private boolean isNegativeTryCount(String input) {
        return Integer.parseInt(input) < 0;
    }

    private boolean isZeroTryCount(String input) {
        return Integer.parseInt(input) == 0;
    }
}
