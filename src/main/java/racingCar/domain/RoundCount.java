package racingCar.domain;

import racingCar.domain.exception.count.CountRangeException;

public class RoundCount {
    private int count;

    public RoundCount(int count) {
        validate(count);
        this.count = count;
    }

    public void minusOne() {
        count--;
    }

    public boolean isFinish() {
        return count == 0;
    }

    private static void validate(int count) {
        if (count <= 0) {
            throw new CountRangeException();
        }
    }

    public int get() {
        return count;
    }
}