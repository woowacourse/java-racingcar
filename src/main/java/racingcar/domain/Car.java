package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int MINIMUM_DRIVE_CONDITION = 4;
    private static final int DEFAULT_POSITION_VALUE = 0;

    private final Name name;
    private int position = DEFAULT_POSITION_VALUE;

    public Car(final String name) {
        this.name = new Name(name);
    }

    public void drive(int value) {
        if (MINIMUM_DRIVE_CONDITION <= value) {
            this.position++;
        }
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
