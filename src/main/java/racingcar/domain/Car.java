package racingcar.domain;

import racingcar.validator.CarValidator;

import java.util.Objects;

public class Car {
    private final String name;

    private Car(String name) {
        CarValidator.validateCarNameIsNullOrEmpty(name);
        String trimmedName = name.trim();
        CarValidator.validateCarNameLength(trimmedName);
        this.name = trimmedName;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
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
