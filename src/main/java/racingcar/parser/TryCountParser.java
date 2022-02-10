package racingcar.parser;

import racingcar.parser.exception.TryCountException;

public class TryCountParser {

    public int parse(String input) {
        validateTryCount(input);
        return Integer.parseInt(input);
    }

    private void validateTryCount(String input) {
        checkNullTryCount(input);
        checkBlankTryCount(input);
        checkFloatTryCount(input);
        checkNegativeTryCount(input);
        checkZeroTryCount(input);
    }

    private void checkNullTryCount(String input) {
        if (input == null) {
            throw new TryCountException("시도 횟수는 NULL값일 수 없습니다.");
        }
    }

    private void checkBlankTryCount(String input) {
        if (isBlankTryCount(input)) {
            throw new TryCountException("시도 횟수는 공백일 수 없습니다.");
        }
    }

    private void checkFloatTryCount(String input) {
        if (isFloatTryCount(input)) {
            throw new TryCountException("시도 횟수는 실수가 될 수 없습니다.");
        }
    }

    private void checkNegativeTryCount(String input) {
        if (isNegativeTryCount(input)) {
            throw new TryCountException("시도 횟수는 음수가 될 수 없습니다.");
        }
    }

    private void checkZeroTryCount(String input) {
        if (isZeroTryCount(input)) {
            throw new TryCountException("시도 횟수는 0이 될 수 없습니다.");
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
