package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int INIT_POSITION = 1;
    public static final int SAME_POSITION_NUMBER = 0;

    private Position position = new Position(INIT_POSITION);
    private final CarName name;

    public Car(final CarName name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("null은 사용할 수 없습니다. CarName타입을 사용하세요.");
        }
        this.name = name;
    }

    public boolean isSamePositionWith(final Car other) {
        return compareTo(other) == SAME_POSITION_NUMBER;
    }

    public void attemptToMove(final boolean canMove) {
        if (canMove) {
            this.position = position.move();
        }
    }

    public Position getPosition() {
        return position;
    }

    public CarName getName() {
        return name;
    }

    @Override
    public int compareTo(final Car other) {
        return position.compareTo(other.getPosition());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Car car = (Car) other;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
