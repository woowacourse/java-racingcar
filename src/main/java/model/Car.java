package model;

import exception.ErrorCode;
import java.util.Objects;
import type.CarInformation;

public class Car {

    private static final int MOVE_POWER_LIMIT = 4;
    private static final int DEFAULT_POSITION = 1;
    private static final int MOVE_UNIT = 1;
    private final String name;
    private int position;

    public Car(final String name) {
        validate(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public void move(int power) {
        if (power >= MOVE_POWER_LIMIT) {
            this.position += MOVE_UNIT;
        }
    }

    private void validate(final String name) {
        if (isCarNameLengthInRange(name.length())) {
            return;
        }
        throw new IllegalArgumentException(ErrorCode.CAR_NAME_OUT_OF_RANGE.getMessage());
    }

    private boolean isCarNameLengthInRange(final int nameLength) {
        return nameLength >= CarInformation.NAME_MIN.getValue()
            && nameLength <= CarInformation.NAME_MAX.getValue();
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return position;
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
