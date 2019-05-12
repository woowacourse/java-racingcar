package racingcar.domain;

import java.util.Objects;
import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(final String name) {
        this.name = name;
    }

    public Car(final String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        if (Rule.isPossibleMove()) {
            this.position++;
        }
    }

    /* For Test */
    public void move(int num) {
        if (Rule.isPossibleMove(num)) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
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

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
