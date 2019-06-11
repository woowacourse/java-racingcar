package domain;

import java.util.Objects;

public class Car {
    private final String name;
    private final Distance distance;

    private Car(String name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car of(String name, Distance distance) {
        return new Car(name, distance);
    }

    public Car move(MoveStrategy strategy) {
        if (strategy.canMove()) {
            return new Car(name, distance.increased());
        }
        return this;
    }

    public int getNumDistance() {
        return distance.toInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
