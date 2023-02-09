package racingcar.dto;

import static racingcar.exception.ExceptionMessage.*;

public class TryCountRequest {
    private final int tryCount;

    private TryCountRequest(int tryCount) {
        this.tryCount = tryCount;
    }

    public static TryCountRequest of(String input) {
        int tryCount = stringToInt(input);
        validateNegativeNumber(tryCount);
        return new TryCountRequest(tryCount);
    }

    private static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_TRY_COUNT.getMessage());
        }
    }

    private static void validateNegativeNumber(Integer tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException(ILLEGAL_TRY_COUNT.getMessage());
        }
    }

    public int getTryCount() {
        return tryCount;
    }
}
