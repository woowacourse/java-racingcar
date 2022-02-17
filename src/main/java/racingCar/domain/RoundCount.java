package racingCar.domain;

import racingCar.domain.exception.count.CountRangeException;

public class RoundCount {
    private static final int MINIMUM_NUM = 0;
    private int count;

    public RoundCount(int count) {
        validate(count);
        this.count = count;
    }

    public void minusOne() {
        count--;
    }

    public boolean isFinish() {
        return count == MINIMUM_NUM;
    }

    private static void validate(int count) {
        if (count <= MINIMUM_NUM) {
            throw new CountRangeException();
        }
    }

    public int get() {
        return count;
    }
}