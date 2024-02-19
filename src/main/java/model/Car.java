package model;

import java.util.Objects;

public class Car {

    private static final String CAR_NAME_TOO_LONG = "자동차 이름이 5자 초과입니다.";
    private static final String CAR_NAME_IS_BLANK = "빈 자동차 이름이 존재합니다.";
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;
    private int movement;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.movement = 0;
    }

    private void validateName(String carName) {
        validateNameLength(carName);
        validateNameExists(carName);
    }

    private static void validateNameLength(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG);
        }
    }

    private static void validateNameExists(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_IS_BLANK);
        }
    }

    public void move(boolean move) {
        if (move) {
            this.movement++;
        }
    }

    public boolean isSameMovement(int movement) {
        return this.movement == movement;
    }

    public String getCarName() {
        return name;
    }

    public int getMovement() {
        return movement;
    }

}
