package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static final int MINIMUM_MOVE_POWER = 4;

    private final Name name;
    private final Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(final int power) {
        if (isEnough(power)) {
            position.increase();
        }
    }

    private boolean isEnough(final int power) {
        return power >= MINIMUM_MOVE_POWER;
    }

    public boolean isSamePosition(final Car car) {
        return position.equals(car.position);
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }

    @Override
    public int compareTo(final Car car) {
        return position.getValue() - car.getPosition();
    }

    @Override
    public String toString() {
        return name.getValue();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
