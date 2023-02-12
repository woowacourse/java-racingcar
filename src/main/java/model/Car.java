package model;

import exception.ErrorCode;

public class Car {

    private static final int MOVE_POWER_LIMIT = 4;
    private static final int DEFAULT_POSITION = 1;
    private static final int MOVE_UNIT = 1;
    private static final int MIN_CAR_NAME = 1;
    private static final int MAX_CAR_NAME = 5;
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
        throw new IllegalArgumentException(
            String.format(ErrorCode.CAR_NAME_OUT_OF_RANGE.getMessage(), MIN_CAR_NAME,
                MAX_CAR_NAME));
    }

    private boolean isCarNameLengthInRange(final int nameLength) {
        return nameLength >= MIN_CAR_NAME && nameLength <= MAX_CAR_NAME;
    }

    public int getCurrentPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
