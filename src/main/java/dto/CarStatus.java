package dto;

import domain.Car;
import java.util.Objects;

public class CarStatus {
    private final String name;
    private final int distance;

    public CarStatus(Car car) {
        this.name = car.getName().getName();
        this.distance = car.getDistance().getDistance();
    }

    public static CarStatus of(Car car) {
        return new CarStatus(car);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarStatus carStatus = (CarStatus) o;
        return distance == carStatus.distance && Objects.equals(name, carStatus.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
