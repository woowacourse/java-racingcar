package racingcar.domain.vo;

import java.util.Objects;

public class MovingNumber {
    private static final int MINIMUM_RANGE = 0;
    private static final int MAXIMUM_RANGE = 9;

    private final int number;

    public MovingNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MovingNumber)) {
            return false;
        }
        MovingNumber movingNumber1 = (MovingNumber)o;
        return number == movingNumber1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private void validateRange(int number) {
        if (number < MINIMUM_RANGE || number > MAXIMUM_RANGE) {
            throw new IllegalArgumentException("숫자는 0과 9사이어야 합니다.");
        }
    }
}
