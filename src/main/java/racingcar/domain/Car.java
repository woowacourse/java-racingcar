package racingcar.domain;

import java.util.Objects;
import racingcar.dto.CarStatus;

public class Car implements Comparable<Car> {
    private static final int CAR_MOVE_THRESHOLD = 4;

    private final CarName name;
    private Position position;

    private Car(final CarName name) {
        this.name = name;
        this.position = new Position(0);
    }

    public static Car from(final String name) {
        return new Car(new CarName(name));
    }

    public void move(final int threshold) {
        if (threshold >= CAR_MOVE_THRESHOLD) {
            position = position.increasePosition();
        }
    }

    public String getName() {
        return name.name();
    }

    public CarStatus getCarStatus() {
        return new CarStatus(name.name(), position.position());
    }

    public int compareTo(Car other) {
        return this.position.position() - other.position.position();
    }

    public boolean isSamePosition(Car other) {
        return this.position.position() == other.position.position();
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
