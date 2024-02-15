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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Car car) {
            return this.name.equals(car.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
