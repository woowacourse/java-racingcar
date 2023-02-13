package model;

import java.util.Random;

public class Car extends Vehicle {

    public static final int RANDOM_MOVE_BOUNDARY = 4;
    public static final int RANDOM_NUMBER_GENERATE_RANGE = 10;
    public static final int START_POSITION = 0;


    public Car(String name) {
        super(name, START_POSITION);
    }

    @Override
    public boolean isMove() {
        return new Random().nextInt(RANDOM_NUMBER_GENERATE_RANGE) >= RANDOM_MOVE_BOUNDARY;
    }
}
