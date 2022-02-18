package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int MINIMUM_DRIVE_CONDITION = 4;

    private final Name name;
    private Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void drive(int value) {
        if (MINIMUM_DRIVE_CONDITION <= value) {
            position = position.moveForward();
        }
    }

    public boolean isSamePosition(Car car) {
        return this.position.equals(car.position);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public int compareTo(Car car) {
        return position.compareTo(car.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Car))
            return false;
        Car car = (Car)o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
