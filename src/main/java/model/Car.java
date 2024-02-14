package model;

import utils.RandomNumberGenerator;

public class Car {

    private static final int MOVE_NUMBER = 4;
    private final String name;
    private int movement;

    public Car(String name) {
        this.name = name;
        this.movement = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_NUMBER) {
            this.movement++;
        }
    }
}
