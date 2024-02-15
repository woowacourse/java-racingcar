package model;

public class Car {
    private final Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
    }

    public void moveForward() {
        this.position++;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return this.position;
    }
}
