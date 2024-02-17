package racingcar.domain;

import java.util.regex.Pattern;

public class Round {
    private static final String INVALID_ROUND_EXCEPTION_MESSAGE = "시도할 횟수는 숫자가 아니거나, %d보다 작을 수 없습니다.";
    private static final String VALID_ROUND_REGEX = "[0-9]+";
    private static final int MINIMUM_ROUND = 0;

    private int remainingRound;

    public Round(String inputRound) {
        validateRound(inputRound);
        this.remainingRound = Integer.parseInt(inputRound);
    }

    private void validateRound(String inputRound) {
        if (!isZeroOrPositiveNumber(inputRound)) {
            throw new IllegalArgumentException(
                    String.format(INVALID_ROUND_EXCEPTION_MESSAGE, MINIMUM_ROUND));
        }
    }

    private boolean isZeroOrPositiveNumber(String inputRound) {
        return Pattern.matches(VALID_ROUND_REGEX, inputRound);
    }

    public boolean isLast() {
        return remainingRound == MINIMUM_ROUND;
    }

    public void decrease() {
        this.remainingRound--;
    }
}
