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

    public void move(int power) {
        if(power >= MIN_BOUNDARY_POWER) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }
}
