package domain;

import utils.RandomNumberGenerator;

public class Car {

    private static final int POWER_TO_GO = 4;

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
        return RandomNumberGenerator.generateRandomNumber() >= POWER_TO_GO;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }
}
