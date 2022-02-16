package racingcar.model.car;

import java.util.Objects;

import racingcar.util.NumberValidator;

public class Position implements Comparable<Position> {
    private static final int INCREASE_DISTANCE = 1;
    private static final int DEFAULT_POSITION = 0;

    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position create() {
        return new Position(DEFAULT_POSITION);
    }

    public static Position from(int position) {
        NumberValidator.validateIsNotNegative(position);
        return new Position(position);
    }

    public Position increase() {
        return from(this.position + INCREASE_DISTANCE);
    }

    public int toInt() {
        return position;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Position position1 = (Position)object;
        return position == position1.position;
    }

    @Override
    public int compareTo(Position otherPosition) {
        return position - otherPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
