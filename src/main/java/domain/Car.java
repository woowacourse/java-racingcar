package domain;

import utils.RandomNumberGenerator;

public class Car {

    private final String name;
    private int drivenDistance = 0;

    public Car(String name) {
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
