package racingcargame.model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        checkNameLength(name);
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    private static void checkNameLength(String name) {
        if (name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car update(int randomNumber) {
        if (randomNumber > 4) {
            return new Car(name, position + 1);
        }
        return new Car(name, position);
    }

    public boolean isMax(Car maxCar) {
        if (position == maxCar.position) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.position, car.position);
    }
}
