package domain;

import utils.RandomNumberGenerator;

public class Car {

    private static final int MIN_BOUNDARY_POWER = 4;

    private final String name;
    private int distance;

    public Car(final String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move() {
        this.distance++;
    }

    public boolean canMove() {
        return generatorPower() >= MIN_BOUNDARY_POWER;
    }

    private int generatorPower() {
        return RandomNumberGenerator.generateRandomPower();
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }
}
