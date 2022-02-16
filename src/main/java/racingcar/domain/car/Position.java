package racingcar.domain.car;

import java.util.Objects;

import racingcar.domain.movement.MovementStrategy;

public class Position {

    public static final int DEFAULT_POSITION = 0;
    public static final int MIN_POSITION = 0;

    private int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException("자동차의 위치는 0이상의 양수 값을 가져야 합니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public boolean isSame(int otherPosition) {
        return position == otherPosition;
    }

    public void move(MovementStrategy strategy) {
        position += strategy.move();
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
        return getPosition() == position1.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
