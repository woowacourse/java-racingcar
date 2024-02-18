package racingcar.domain;

import java.util.Objects;
import racingcar.dto.CarStatus;

public class Car implements Comparable<Car> {
    private static final int CAR_MOVE_THRESHOLD = 4;

    private final CarName name;
    private Position position;

    private Car(final CarName name) {
        this.name = name;
        this.position = Position.ZERO;
    }

    public static Car from(final String name) {
        return new Car(new CarName(name));
    }

    public void move(final int number) {
        if (number >= CAR_MOVE_THRESHOLD) {
            position = position.increasePosition();
        }
    }

    public String getName() {
        return name.value();
    }

    public CarStatus getCarStatus() {
        return new CarStatus(name.value(), position.value());
    }

    public int compareTo(Car other) {
        return this.position.value() - other.position.value();
    }

    public boolean isSamePosition(Car other) {
        return this.position.value() == other.position.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
