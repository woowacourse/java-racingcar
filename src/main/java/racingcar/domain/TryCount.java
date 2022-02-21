package racingcar.domain;

import static racingcar.message.ErrorMessages.TRY_CNT_NOT_NUMBER;
import static racingcar.message.ErrorMessages.TRY_CNT_NOT_VALID_NUMBER;

import java.util.Objects;

public class TryCount {
    private static final int TRY_MAX_CNT = 1000;
    private final int tryCount;

    public TryCount(String countString) {
        validateStringIsNumber(countString);
        isValidNumber(countString);
        this.tryCount = convertStringToInt(countString);
    }

    public boolean isNotSame(int tryCount) {
        return this.tryCount != tryCount;
    }

    private void validateStringIsNumber(String input) {
        if (!input.matches("[0-9]")) {
            throw new IllegalArgumentException(TRY_CNT_NOT_NUMBER);
        }
    }

    private void isValidNumber(String input) {
        long count = Long.parseLong(input);
        if (count < 0 || count > TRY_MAX_CNT) {
            throw new IllegalArgumentException(TRY_CNT_NOT_VALID_NUMBER);
        }
    }

    private int convertStringToInt(String string) {
        return Integer.parseInt(string);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TryCount tryCount1 = (TryCount) obj;
        return tryCount == tryCount1.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryCount);
    }

    @Override
    public String toString() {
        return "TryCount{" +
                "tryCount=" + tryCount +
                '}';
    }
}
