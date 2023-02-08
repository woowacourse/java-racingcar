package model;

import exception.ErrorCode;
import type.CarInformation;

public class Car {
    private final String name;

    public Car(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (isCarNameLengthInRange(name.length())) {
            return;
        }
        throw new IllegalArgumentException(ErrorCode.CAR_NAME_OUT_OF_RANGE.getMessage());
    }

    private boolean isCarNameLengthInRange(final int nameLength) {
        return nameLength >= CarInformation.NAME_MIN.getValue() && nameLength <= CarInformation.NAME_MAX.getValue();
    }

}
