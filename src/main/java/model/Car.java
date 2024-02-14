package model;

import java.util.function.Supplier;
import utils.RandomNumberGenerator;

public class Car {

    private static final int MOVE_NUMBER = 4;
    private static final String STEP = "-";
    private final String name;
    private int movement;
    private final Supplier<Integer> generator;

    public Car(String name, Supplier<Integer> generator) {
        this.name = name;
        this.movement = 0;
        this.generator = generator;
    }

    public void move() {
        if (generator.get() >= MOVE_NUMBER) {
            this.movement++;
        }
    }

    public String getCarName(){
        return name;
    }

    public String generateMovement() {
        return STEP.repeat(movement);
    }

    public int getMovement() {
        return movement;
    }
}
