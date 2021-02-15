package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final Name name;
    private final Position position;

    public Car(final Name name) {
        this(name, Position.START);
    }

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Car moveDefinitely() {
        final Position nextPosition = position.move();
        return new Car(name, nextPosition);
    }

    @Override
    public int compareTo(Car o) {
        return position.compareTo(o.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
