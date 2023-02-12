package domain;

import validation.TryCountValidation;

public class TryCount {

    private final int tryCount;

    public TryCount(final int tryCount) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private void validateTryCount(final int tryCount) {
        TryCountValidation.validateTryCount(tryCount);
    }

    public int getTryCount() {
        return tryCount;
    }
}
