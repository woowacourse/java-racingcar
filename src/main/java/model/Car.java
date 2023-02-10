package model;

import exception.ErrorCode;
import java.util.Objects;

public class Car {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Car(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (isCarNameLengthInRange(name.length())) {
            return;
        }
        throw new IllegalArgumentException(
            String.format(ErrorCode.CAR_NAME_OUT_OF_RANGE.getMessage(), MIN_NAME_LENGTH,
                MAX_NAME_LENGTH));
    }

    private boolean isCarNameLengthInRange(final int nameLength) {
        return nameLength >= MIN_NAME_LENGTH &&
            nameLength <= MAX_NAME_LENGTH;
    }

    public String getName() {
        return name;
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
