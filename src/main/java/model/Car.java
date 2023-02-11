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

    private void moveCar() {
        this.location += CAR_MOVE_FORWARD;
    }

    public void moveByRandom(int randNum) {
        if (randNum >= MIN_NUMBER_FOR_CAR_MOVE) {
            this.moveCar();
        }
    }

    public String getCarName() {
        return this.name;
    }

    public int getCarLocation() {
        return this.location;
    }

    public boolean checkLocationEqual(int maxLocation) {
        return this.location == maxLocation;
    }
}
