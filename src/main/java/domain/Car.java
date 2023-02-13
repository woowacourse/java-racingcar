package domain;

import static validation.CarNameValidator.CAR_NAME_VALIDATOR;

import utils.NumberGenerator;

public class Car {

    private final String name;
    private int drivenDistance = 0;
    private final NumberGenerator numberGenerator;

    public Car(final String name, NumberGenerator numberGenerator) {
        CAR_NAME_VALIDATOR.validate(name);
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public void drive() {
        final int DRIVING_DISTANCE = 1;
        final int MOVING_STANDARD = 4;

        int number = chooseNumber();
        if (number >= MOVING_STANDARD) {
            drivenDistance += DRIVING_DISTANCE;
        }
    }

    private int chooseNumber() {
        return numberGenerator.generate();
    }

    public int getDrivenDistance() {
        return drivenDistance;
    }

    public String getName() {
        return name;
    }
}
