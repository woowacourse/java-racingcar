package model;

public class Car {
    private final Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name.getName();
    }
}
