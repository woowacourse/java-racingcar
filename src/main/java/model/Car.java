package model;

import constant.ExceptionMessage;

public class Car {
    private static final int CAR_NAME_LENGTH = 5;
    private static final int CAR_MOVE_LENGTH = 1;
    private static final int CAR_INITIAL_LENGTH = 0;


    private String name;
    private int location;

    public Car(String name) {
        validCarName(name);
        this.name = name;
        this.location = CAR_INITIAL_LENGTH;
    }

    private void validCarName(String name) {
        if (name.isEmpty() || name.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    ExceptionMessage.EXCEPTION_MESSAGE.getExceptionMessage());
        }
        if (isOnlySpace(name)) {
            throw new IllegalArgumentException(
                    ExceptionMessage.EXCEPTION_SPACE_MESSAGE.getExceptionMessage());
        }
    }

    private boolean isOnlySpace(String name) {
        return name.trim().isBlank();
    }

    private void moveCar() {
        this.location += CAR_MOVE_LENGTH;
    }

    public void moveByRandom(boolean move) {
        if (move) {
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
