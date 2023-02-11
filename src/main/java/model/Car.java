package model;

import constant.ExceptionMessage;

public class Car {
    private final int CAR_LOCATION_INITIALIZATION = 0;
    private final int MAX_CAR_NAME_LENGTH = 5;
    private final int CAR_MOVE_FORWARD = 1;
    private final int MIN_NUMBER_FOR_CAR_MOVE = 4;

    private final String name;
    private int location;

    public Car(String name) {
        validCarName(name);
        this.name = name;
        this.location = CAR_LOCATION_INITIALIZATION;
    }

    private void validCarName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    ExceptionMessage.EXCEPTION_MESSAGE.getExceptionMessage());
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    ExceptionMessage.EXCEPTION_SPACE_MESSAGE.getExceptionMessage());
        }
    }

    public void moveByNumber(int number) {
        if (number >= MIN_NUMBER_FOR_CAR_MOVE) {
            this.moveCar();
        }
    }

    private void moveCar() {
        this.location += CAR_MOVE_FORWARD;
    }

    public String getCarName() {
        return this.name;
    }

    public int getCarLocation() {
        return this.location;
    }

    public boolean isLocationEqual(int maxLocation) {
        return this.location == maxLocation;
    }
}
