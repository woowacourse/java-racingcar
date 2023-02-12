package domain;

import validation.TryCountValidation;

public class Game {

    private final int tryCount;

    public Game(final int tryCount) {
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
