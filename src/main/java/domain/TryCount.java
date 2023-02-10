package domain;

import static exception.ErrorMessage.ENTER_POSITIVE_INTEGER;

import exception.NotPositiveIntegerException;

public class TryCount {

    private static final int EXCEPTION_FLAG = 0;

    private final int tryCount;

    public TryCount(final String inputCount) {
        this.tryCount = validateTryCount(inputCount);
    }

    private TryCount(final int tryCount) {
        this.tryCount = tryCount;
    }

    private int validateTryCount(final String inputCount) {
        int tryCount = Integer.parseInt(inputCount);

        if(tryCount <= EXCEPTION_FLAG){
            throw new NotPositiveIntegerException(ENTER_POSITIVE_INTEGER.toString());
        }

        return tryCount;
    }

    public TryCount deduct() {
        return new TryCount(tryCount - 1);
    }

    public boolean isZero() {
        return this.tryCount == EXCEPTION_FLAG;
    }
}
