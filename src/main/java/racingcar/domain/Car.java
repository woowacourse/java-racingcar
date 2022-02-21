package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int MOVING_DEMANDED_MINIMUM_NUMBER = 4;
    private static final int DEFAULT_POSITION_VALUE = 0;

    private final Name name;
    private Position position;

    private Car(Name name) {
        this.name = name;
        this.position = Position.from(DEFAULT_POSITION_VALUE);
    }

    public static Car fromName(Name name) {
        return new Car(name);
    }

    public void drive(int value) {
        if (MOVING_DEMANDED_MINIMUM_NUMBER <= value) {
            this.position = this.position.increase();
        }
    }

    public boolean isSamePosition(Car car) {
        return this.position.equals(car.position);
    }

    public Position getPosition() {
        return this.position;
    }

    public Name getName() {
        return this.name;
    }

    @Override
    public int compareTo(Car car) {
        return this.position.compareTo(car.getPosition());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Car)) {
            return false;
        }
        Car car = (Car) object;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
