package domain;

import java.util.Objects;

public class Car {
    private final CarName name;
    private final Distance distance;

    private Car(CarName name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car of(CarName name, Distance distance) {
        return new Car(name, distance);
    }

    public Car move(MoveStrategy strategy) {
        if (strategy.canMove()) {
            return new Car(name, distance.increased());
        }
        return this;
    }

    public String getName() {
        return name.toString();
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
