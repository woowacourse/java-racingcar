package racingcar.controller;

import static racingcar.controller.TryCount.Validator.*;
import static racingcar.exception.ExceptionMessage.ILLEGAL_TRY_COUNT;

public class TryCount {
    private int tryCount;

    public TryCount(int tryCount) {
        validateNegativeTryCount(tryCount);
        validateOverMaxTryCount(tryCount);
        this.tryCount = tryCount;
    }

    public static class Validator {
        private static final int MAX_TRY_COUNT = 100;

        private Validator() {
        }

        public static void validateNegativeTryCount(int tryCount) {
            if (tryCount < 0) {
                throw new IllegalArgumentException(ILLEGAL_TRY_COUNT.getMessage());
            }
        }

        public static void validateOverMaxTryCount(int tryCount) {
            if (tryCount >= MAX_TRY_COUNT) {
                throw new IllegalArgumentException(ILLEGAL_TRY_COUNT.getMessage());
            }
        }
    }

    public void countdown() {
        tryCount--;
    }

    public boolean isRemaining() {
        return tryCount > 0;
    }
}
