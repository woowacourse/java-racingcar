package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int INIT_POSITION = 1;

    private Position position = new Position(INIT_POSITION);
    private final CarName name;

    public Car(final CarName name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public int compareTo(final Car other) {
        return position.compareTo(other.getPosition());
    }

    public boolean isSamePositionWith(final Car other) {
        return compareTo(other) == 0;
    }

    public CarName getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        Car car = (Car)other;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void attemptToMove(final boolean canMove) {
        if (canMove) {
            this.position = position.move();
        }
    }
}
