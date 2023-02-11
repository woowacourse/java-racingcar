package racingcar.dto;

import static racingcar.dto.TryCountRequest.Validator.validateNegativeTryCount;
import static racingcar.exception.ExceptionMessage.ILLEGAL_TRY_COUNT;

public class TryCountRequest {
    private final int tryCount;

    public TryCountRequest(int tryCount) {
        this.tryCount = tryCount;
    }

    public static TryCountRequest of(String input) {
        int tryCount = stringToInt(input);
        validateNegativeTryCount(tryCount);
        return new TryCountRequest(tryCount);
    }

    private static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_TRY_COUNT.getMessage());
        }
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

    public int getTryCount() {
        return tryCount;
    }
}
