package domain;

import utils.RandomNumberGenerator;

public class Car {

    private final Name name;
    private int drivenDistance = 0;

    public Car(String name, int index) {
        this.name = new Name(name, index);
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

    @Override
    public String toString() {
        return name.toString();
    }
}
