package domain;

import validation.CarNamesValidation;

public class Car {

    private static final int MIN_BOUNDARY_POWER = 4;

    private final String carName;
    private int distance;

    public Car(final String carName, int distance) {
        validateName(carName);
        this.carName = carName;
        this.distance = distance;
    }

    private void validateName(String carName) {
        CarNamesValidation.validateCarName(carName);
    }

    public void move(final int power) {
        if (power >= MIN_BOUNDARY_POWER) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }

    public String getCarName() {
        return this.carName;
    }
}
