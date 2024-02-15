package model;

public class Car {

    private final String name;
    private int movement;

    public Car(String name) {
        this.name = name;
        this.movement = 0;
    }

    public void move(boolean move) {
        if (move) {
            this.movement++;
        }
    }

    public String getCarName() {
        return name;
    }

    public int getMovement() {
        return movement;
    }
}
