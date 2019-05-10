package racingcar.domain;

import racingcar.view.Validation;

public class Car implements Comparable<Car> {
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
        if (!Validation.isAValidName(name) || position < 0) {
            throw new IllegalArgumentException();
        }
    }

    public Car move(MovementStrategy cond) {
        if (cond.isMovable()) {
            position++;
        }
        return this;
    }

    public String drawTrail() {
        StringBuffer trail = new StringBuffer();
        for (int i = 0; i < position; i++) {
            trail.append("-");
        }
        return trail.toString();
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isAtSamePositionWith(Car rhs) {
        return position == rhs.position;
    }

    @Override
    public int compareTo(Car rhs) {
        return rhs.position - position;
    }

    @Override
    public boolean equals(Object rhs) {
        if (rhs == this) {
            return true;
        }
        if (!(rhs instanceof Car)) {
            return false;
        }
        Car car = (Car) rhs;
        return name == car.name && position == car.position;
    }

    @Override
    public int hashCode() {
        return name.length() * 65535 + position;
    }
}