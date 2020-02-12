package model;

import java.util.Objects;

public class Car {
    public static final int ONE_STEP = 1;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void move() {
        position += ONE_STEP;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
