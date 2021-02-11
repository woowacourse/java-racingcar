package javaracingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MIN_CAN_MOVE_NUMBER = 4;

    private Name name;
    private int position;

    public Car(String name) {
        this(new Name(name), 0);
    }

    public Car(String name, int position) {
        this(new Name(name), position);
    }

    public Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= MIN_CAN_MOVE_NUMBER) {
            position++;
        }
    }

    public boolean isAtPosition(int position) {
        return this.position == position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
