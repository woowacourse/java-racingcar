package racingCar.domain;

import racingCar.domain.exception.count.CountRangeException;

public class RoundCount {
    private int count;

    public RoundCount(int count) {
        validate(count);
        this.count = count;
    }

    private static void validate(int count) {
        if (count <= 0) {
            throw new CountRangeException();
        }
    }

    public void minusOne() {
        count--;
    }

    public boolean isFinish() {
        return count == 0;
    }

    public int get() {
        return count;
    }
}