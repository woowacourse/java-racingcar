package racingcar.model.car;

import racingcar.util.NumberValidator;

import java.util.Objects;

class Position implements Comparable<Position> {
    private static final int INCREASE_DISTANCE = 1;
    private static final String DISTANCE_BAR = "-";

    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position create() {
        return new Position(0);
    }

    public static Position from(int position) {
        NumberValidator.validateIsNotNegative(position);
        return new Position(position);
    }

    public Position increase() {
        return from(this.position + INCREASE_DISTANCE);
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
    public int compareTo(Position otherPosition) {
        return otherPosition.position - position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return DISTANCE_BAR.repeat(position);
    }
}