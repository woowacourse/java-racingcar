package racingcar.domain;

import racingcar.constant.Digit;
import racingcar.constant.Message;

public class Times {
    private final int times;

    public Times(int times) {
        validate(times);
        this.times = times;
    }

    private void validate(int times) {
        validatePositive(times);
        validateLimitation(times);
    }

    private void validatePositive(int times) {
        if (times <= Digit.ZERO.getDigit()) {
            throw new IllegalArgumentException(Message.NON_POSITIVE_ERROR.toString());
        }
    }

    private void validateLimitation(int times) {
        if (times <= Digit.TIMES_LIMITATION.getDigit()) {
            return;
        }
        throw new IllegalArgumentException(Message.LIMITATION_ERROR.toString());
    }

    public boolean isZero() {
        return times == Digit.ZERO.getDigit();
    }
}
