package racingcar.domain.car;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int MIN_MOVABLE_VALUE = 4;

    private final Name name;
    private Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name, int position) {
        return new Car(Name.from(name), Position.from(position));
    }

    public void move(int value) {
        if (value >= MIN_MOVABLE_VALUE) {
            position = position.increase();
        }
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return name.equals(car.name);
    }

    @Override
    public int compareTo(Car car) {
        return position.compareTo(car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, position);
    }
}
