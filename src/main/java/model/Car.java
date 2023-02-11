package model;

import constant.ExceptionMessage;

public class Car {
    private final String name;
    private int location;

    public Car(String name) {
        validCarName(name);
        this.name = name;
        this.location = 0;
    }

    private void validCarName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(
                    ExceptionMessage.EXCEPTION_MESSAGE.getExceptionMessage());
        }
        if (isOnlySpace(name)) {
            throw new IllegalArgumentException(
                    ExceptionMessage.EXCEPTION_SPACE_MESSAGE.getExceptionMessage());
        }
    }

    private boolean isOnlySpace(String name) {
        return name.replace(" ", "").length() == 0;
    }

    private void moveCar() {
        this.location += 1;
    }

    public void moveByRandom(int randNum) {
        if (randNum >= 4) {
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
