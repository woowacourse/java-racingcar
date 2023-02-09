package racingcar.dto;

import static racingcar.validator.Validator.*;

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

    public int getTryCount() {
        return tryCount;
    }
}
