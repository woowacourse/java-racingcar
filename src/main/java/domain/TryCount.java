package domain;

import exception.NotPositiveIntegerException;

public class TryCount {

    private static final int END_FLAG = 0;

    private final int tryCount;

    public TryCount(final String inputCount) {
        validateTryCount(inputCount);
        this.tryCount = Integer.parseInt(inputCount);
    }

    private TryCount(final int tryCount) {
        this.tryCount = tryCount;
    }

    private void validateTryCount(final String inputCount) {
        int tryCount = Integer.parseInt(inputCount);

        if (tryCount <= END_FLAG) {
            throw new NotPositiveIntegerException();
        }
    }

    public TryCount deduct() {
        return new TryCount(tryCount - 1);
    }

    public boolean isZero() {
        return this.tryCount == END_FLAG;
    }
}
