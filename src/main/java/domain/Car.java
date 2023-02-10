package domain;

import utils.RandomNumberGenerator;

public class Car {

    private final Name name;
    private int drivenDistance = 0;

    public Car(String name, int order) {
        this.name = new Name(name, order);
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
        return name.getName();
    }

    public int getOrder(){
        return name.getOrder();
    }
}
