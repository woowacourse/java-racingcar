package domain;

import static validation.CarNameValidator.CAR_NAME_VALIDATOR;

import utils.NumberGenerator;
import utils.RandomNumberGenerator;

public class Car {

    private final String name;
    private int drivenDistance = 0;
    private final NumberGenerator numberGenerator;
    private final Judge judge;

    public Car(final String name, Judge judge) {
        CAR_NAME_VALIDATOR.validate(name);
        this.name = name;
        numberGenerator = new RandomNumberGenerator();
        this.judge = judge;
    }

    public void drive() {
        final int DRIVING_DISTANCE = 1;

        int number = chooseNumber();
        if (judge.judgeDriving(number)) {
            drivenDistance += DRIVING_DISTANCE;
        }
    }

    private int chooseNumber() {
        return numberGenerator.generateNumber();
    }

    public int getDrivenDistance() {
        return drivenDistance;
    }

    public String getName() {
        return name;
    }
}
