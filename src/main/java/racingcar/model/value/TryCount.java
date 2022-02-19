package racingcar.model.value;

import static racingcar.message.ErrorMessages.*;

import java.util.Objects;

public class TryCount {
    private final int tryCount;

    private TryCount(int tryCount) {
        this.tryCount = tryCount;
        validate();
    }

    public static TryCount fromString(String countString) {
        return new TryCount(convertStringToInt(countString));
    }

    public static TryCount initialize() {
        return new TryCount(0);
    }

    public TryCount increase() {
        return new TryCount(tryCount + 1);
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

    private static int convertStringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_CNT_NOT_NUMBER);
        }
    }

    private void validate() {
        if (tryCount < 0) {
            throw new IllegalArgumentException(TRY_CNT_NOT_POSITIVE);
        }
    }
}
