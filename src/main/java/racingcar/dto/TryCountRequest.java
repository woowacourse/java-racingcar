package racingcar.dto;

import static racingcar.exception.ExceptionMessage.*;

import java.util.Optional;

public class TryCountRequest {
    private final int tryCount;

    private TryCountRequest(int tryCount) {
        this.tryCount = tryCount;
    }

    public static TryCountRequest of(String input) {
        Optional<Integer> maybeTryCount = Optional.of(Integer.parseInt(input));
        Integer tryCount = maybeTryCount.orElseThrow(
                () -> new IllegalArgumentException(ILLEGAL_TRY_COUNT.getMessage()));
        validateNegativeNumber(tryCount);
        return new TryCountRequest(tryCount);
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
