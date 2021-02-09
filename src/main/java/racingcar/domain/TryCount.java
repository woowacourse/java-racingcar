package racingcar.domain;

import java.util.regex.Pattern;

public class TryCount {
    private static final String REGEX_DIGIT = "^[0-9]*$";

    public int count;

    public TryCount(final String count) {
        validateCount(count);
        this.count = Integer.parseInt(count);
    }

    public boolean isRemainCount() {
        return this.count > 0;
    }

    public void deductCount() {
        this.count--;
    }

    private void validateCount(final String tryCount) {
        if (!isValidNumber(tryCount)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidNumber(final String tryNumber) {
        return Pattern.matches(REGEX_DIGIT, tryNumber);
    }
}
