package racingcar.vo;

import java.util.Objects;

public class Number {
    private static final int MINIMUM_RANGE = 0;
    private static final int MAXIMUM_RANGE = 9;

    private final int number;

    public Number(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MINIMUM_RANGE || number > MAXIMUM_RANGE) {
            throw new IllegalArgumentException("숫자는 0과 9사이어야 합니다.");
        }
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Number)) {
            return false;
        }
        Number number1 = (Number)o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public static Number create(int number) {
        return new Number(number);
    }
}
