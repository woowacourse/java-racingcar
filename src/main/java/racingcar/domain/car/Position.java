package racingcar.domain.car;

import java.util.Objects;

import racingcar.domain.movement.MovementStrategy;

public class Position {

    private int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        this.value = value;
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
