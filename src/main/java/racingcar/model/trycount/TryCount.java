package racingcar.model.trycount;

import racingcar.util.NumberValidator;

public class TryCount {
    private final int tryCount;

    public TryCount(int tryCount) {
        NumberValidator.validateIsPositive(tryCount);
        this.tryCount = tryCount;
    }

    public int toInt() {
        return tryCount;
    }
}
