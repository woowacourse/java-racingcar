package racingcar.domain;

import static racingcar.domain.TryCount.Validator.*;
import static racingcar.exception.ExceptionMessage.ILLEGAL_TRY_COUNT;

public class TryCount {
    private int tryCount;

    public TryCount(int tryCount) {
        validateNegativeTryCount(tryCount);
        this.tryCount = tryCount;
    }

    public static class Validator {

        private Validator() {
        }

        public static void validateNegativeTryCount(Integer tryCount) {
            if (tryCount < 0) {
                throw new IllegalArgumentException(ILLEGAL_TRY_COUNT.getMessage());
            }
        }
    }

    public boolean countdown() {
        if (tryCount <= 0) {
            return false;
        }
        tryCount--;
        return true;
    }
}
