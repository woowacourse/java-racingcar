package domain;

import java.util.Objects;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        position = 0;
        this.name = name;
    }

    private void validate(String name) {
        if (!validateRange(name)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean validateRange(String name) {
        return name.length() > 0 && name.length() <= 5;
    }

    public void execute(int number) {
        if (number >= 4) {
            this.move();
        }
    }

    private void move() {
        position++;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
