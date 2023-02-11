package domain;

import error.ErrorMessage;

public class TryCount {
    private static final int MIN_COUNT = 1;

    private int count;

    public TryCount(int count) {
        validate(count);
        this.count = count;
    }

    public void decreaseCount() {
        count--;
    }

    public boolean canTry() {
        return this.count > 0;
    }

    private void validate(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getValue());
        }
    }
}
