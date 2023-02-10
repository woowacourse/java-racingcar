package domain;

import static validation.CarNameValidator.CAR_NAME_VALIDATOR;

import utils.NumberGenerator;
import utils.RandomNumberGenerator;

public class Car {

    private final String name;
    private int drivenDistance = 0;
    private final NumberGenerator numberGenerator;

    public Car(final String name) {
        CAR_NAME_VALIDATOR.validate(name);
        this.name = name;
        numberGenerator = new RandomNumberGenerator();
    }

    public void drive(int distance) {
        drivenDistance += distance;
    }

    public int chooseNumber() {
        return numberGenerator.generateNumber();
    }

    public int getDrivenDistance() {
        return drivenDistance;
    }

    public String getName() {
        return name;
    }
}
