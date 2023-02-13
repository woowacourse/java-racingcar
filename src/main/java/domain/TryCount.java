package domain;

import validation.TryCountValidation;

public class TryCount {

    private final int tryCount;

    public TryCount(final int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    private void validate(final int tryCount) {
        TryCountValidation.validateTryCount(tryCount);
    }

    public int getTryCount() {
        return tryCount;
    }
}
