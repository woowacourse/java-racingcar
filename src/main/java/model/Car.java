package model;

import java.util.Random;

public class Car implements MovableStrategy{
    public static final int RANDOM_MOVE_BOUNDARY = 4;
    public static final int RANDOM_NUMBER_GENERATE_UPPER_BOUND = 10;

    private final String name;
    private final Random random;

    public Car(String name) {
        this.name = name;
        this.random = new Random();
    }

    @Override
    public boolean isMove() {
        return random.nextInt(RANDOM_NUMBER_GENERATE_UPPER_BOUND) >= RANDOM_MOVE_BOUNDARY;
    }

    @Override
    public String toString() {
        return name;
    }
}
