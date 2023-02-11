package racingcar.service;

import static racingcar.exception.ExceptionMessage.ILLEGAL_TRY_COUNT;

public class TryCount {
    private final int count;

    public TryCount(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count){
        if (count < 0) {
            throw new IllegalArgumentException(ILLEGAL_TRY_COUNT.getMessage());
        }
    }

    public int getCount() {
        return count;
    }
}
