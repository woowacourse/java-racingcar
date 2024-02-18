package model;

import util.NumberGenerator;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
    }

    public void moveForward(NumberGenerator numberGenerator) {
        final int number = numberGenerator.generateNumber();
        if (number >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
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
