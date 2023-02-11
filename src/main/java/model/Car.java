package model;

import message.Constant;

public class Car {

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public boolean move(int randomNumber) {
        return randomNumber >= Constant.RANDOM_MOVE_BOUNDARY;
    }

    @Override
    public String toString() {
        return name;
    }
}
