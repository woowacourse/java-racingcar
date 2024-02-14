package model;

import utils.RandomNumberGenerator;

public class Car {

    private static final int MOVE_NUMBER = 4;
    private final String name;
    private int movement;
    private final RandomNumberGenerator generator;

    public Car(String name) {
        this.name = name;
        this.generator = new RandomNumberGenerator();
        this.movement = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_NUMBER) {
            this.movement++;
        }
    }
}
