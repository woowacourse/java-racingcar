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
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Car && this.hashCode() == object.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
