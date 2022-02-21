package racingCar.domain;

import java.util.Objects;
import racingCar.exception.count.CountRangeException;

public class RoundCount {
    private static final int MINIMUM_NUM = 0;
    private int count;

    public RoundCount(int count) {
        validate(count);
        this.count = count;
    }

    private static void validate(int count) {
        if (count <= MINIMUM_NUM) {
            throw new CountRangeException();
        }
    }

    public void minusOne() {
        count--;
    }

    public boolean isFinish() {
        return count == MINIMUM_NUM;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundCount that = (RoundCount) obj;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}