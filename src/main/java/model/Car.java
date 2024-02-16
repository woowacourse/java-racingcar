package model;

import utils.ErrorMessage;

public class Car {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;
    private int movement;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.movement = 0;
    }

    public void move(boolean move) {
        if (move) {
            this.movement++;
        }
    }

    public String getCarName() {
        return name;
    }

    public int getMovement() {
        return movement;
    }


    private void validateName(String carName) {
        validateNameLength(carName);
        validateNameExists(carName);
    }

    private static void validateNameLength(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_TOO_LONG);
        }
    }

    private static void validateNameExists(String carName) {
        if(carName.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_IS_BLANK);
        }
    }
}
