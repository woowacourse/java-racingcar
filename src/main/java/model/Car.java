package model;

public class Car {

    private final int MOVE_BOUNDARY = 4;

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public boolean move(int randomNumber) {
        return randomNumber >= MOVE_BOUNDARY;
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
