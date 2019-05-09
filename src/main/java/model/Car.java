package model;

public class Car {
    private final String name;
    private int position;

    Car(String name) {
        this.name = name;
    }

    Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
