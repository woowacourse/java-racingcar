package domain;

import static validation.CarNameValidator.CAR_NAME_VALIDATOR;

import utils.RandomNumberGenerator;

public class Car {

    private final String name;
    private int drivenDistance = 0;

    public Car(final String name) {
        CAR_NAME_VALIDATOR.validate(name);
        this.name = name;
    }

    public void drive(int distance) {
        drivenDistance += distance;
    }

    public int chooseNumber() {
        return RandomNumberGenerator.generateNumber();
    }

    public int getDrivenDistance() {
        return drivenDistance;
    }

    public String getName() {
        return name;
    }
}
