package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void moveOrHold(Boolean isMove) {
        if (isMove) {
            this.position++;
        }
    }

    public boolean isSamePosition(Car maxCar) {
        return position == maxCar.getPosition();
    }

    public int compareTo(Car s) {
        return position - s.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car)o;
        return getPosition() == car.getPosition() && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
