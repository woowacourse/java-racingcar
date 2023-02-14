package domain;

import utils.NumberGenerator;

public class Car {

    private static final int DRIVING_DISTANCE = 1;
    private static final int MOVING_STANDARD = 4;

    private final CarName name;
    private int drivenDistance = 0;
    private final NumberGenerator numberGenerator;

    public Car(final String name, NumberGenerator numberGenerator) {
        this.name = new CarName(name);
        this.numberGenerator = numberGenerator;
    }

    public void drive() {
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
        return name.getName();
    }
}
