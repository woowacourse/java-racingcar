package racingcar.domain.car;

import java.util.Objects;

import racingcar.domain.movement.MovementStrategy;
import racingcar.exception.NumberTooSmallException;

public class Position {

    private static final int MIN_VALUE = 0;
    private int value;

    public Position() {
        this(MIN_VALUE);
    }

    public Position(int value) {
        validateMinimum(value);
        this.value = value;
    }

    private void validateMinimum(int value) {
        if (value < MIN_VALUE) {
            throw new NumberTooSmallException("자동차의 위치는 0 미만이 될 수 없습니다.");
        }
    }

    public boolean isSame(int num) {
        return value == num;
    }

    public void move(MovementStrategy strategy) {
        value += strategy.move();
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
