package racingcar.domain;

import racingcar.domain.dto.DrivingDistance;

import java.util.Objects;

import static racingcar.enumType.DomainConstant.CAR_NAME_MAX_LENGTH;
import static racingcar.enumType.ExceptionMessage.BLANK_MESSAGE;
import static racingcar.enumType.ExceptionMessage.LENGTH_MESSAGE;

public class Car {
    private final String name;

    private final StringBuilder drivingMark;

    private Car(final String name) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name = name;
        this.drivingMark = new StringBuilder("-");
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public String getName() {
        return this.name;
    }

    private void validateNameLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException(LENGTH_MESSAGE.getValue());
        }
    }

    private void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_MESSAGE.getValue());
        }
    }

    public void move() {
        drivingMark.append("-");
    }

    public DrivingDistance getDrivingDistance() {
        return DrivingDistance.of(drivingMark.length());
    }

    @Override
    public String toString() {
        return name + " : " + drivingMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
