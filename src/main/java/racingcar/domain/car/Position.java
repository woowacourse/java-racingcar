package racingcar.domain.car;

import java.util.Objects;

import racingcar.domain.movement.MovementStrategy;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("자동차의 위치는 0이상의 양수 값을 가져야 합니다.");
        }
    }

    public boolean isSame(int num) {
        return position == num;
    }

    public void move(MovementStrategy strategy) {
        position += strategy.move();
    }

    public int getValue() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
