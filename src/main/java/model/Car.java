package model;

import constant.ExceptionMessage;

public class Car {
    private String name;
    private int location;
    private ExceptionMessage exceptionMessage;

    public Car(String name) {
        validCarName(name);
        this.name = name;
        this.location = 0;
    }

    private void validCarName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(
                    exceptionMessage.getExceptionMessage(ExceptionMessage.EXCEPTION_MESSAGE));
        }
        if (isOnlySpace(name)) {
            throw new IllegalArgumentException(
                    exceptionMessage.getExceptionMessage(ExceptionMessage.EXCEPTION_SPACE_MESSAGE));
        }
    }

    private boolean isOnlySpace(String name) {
        return name.replace(" ", "").length() == 0;
    }

    private void moveCar() {
        this.location += 1;
    }

    public void moveByRandom(int randNum) {
        if (randNum >= 4)
            this.moveCar();
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
