package racingcar.domain;

import racingcar.dto.CarDto;

import java.util.Objects;

public class Car {
    private static final int INITIAL_DISTANCE = 0;
    private final CarName carName;
    private int distance;

    public Car(final String carName) {
        this.carName = new CarName(carName);
        distance = INITIAL_DISTANCE;
    }

    public void move(final boolean movement) {
        if (movement) {
            distance++;
        }
    }

    public CarDto info() {
        return new CarDto(carName.value(), distance);
    }

    public boolean isFartherThan(final Car another) {
        return this.distance >= another.distance;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, distance);
    }
}
