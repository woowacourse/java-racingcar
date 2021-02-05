package racingcar.domain;

import java.util.regex.Pattern;

public class TryCount {
    private static final String REGEX_DIGIT = "^[0-9]*$";

    public int count;

    public TryCount(final String count) {
        validateCount(count);
        this.count = Integer.parseInt(count);
    }

    public int getCount() {
        return count;
    }

    private void validateCount(final String tryCount) {
        if (!isValidNumber(tryCount)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidNumber(final String tryNumber) {
        return Pattern.matches(REGEX_DIGIT, tryNumber);
    }
}
