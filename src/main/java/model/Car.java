package model;

public class Car {
    public static final int RANDOM_MOVE_BOUNDARY = 4;

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public boolean move(int randomNumber) {
        return randomNumber >= RANDOM_MOVE_BOUNDARY;
    }

    @Override
    public String toString() {
        return name;
    }
}
