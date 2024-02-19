package dto;

import domain.Car;
import java.util.Objects;

public class CarReponse {
    private final String name;
    private final int distance;

    public CarReponse(final Car car) {
        this.name = car.getName().getName();
        this.distance = car.getDistance().getDistance();
    }

    public static CarReponse of(Car car) {
        return new CarReponse(car);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarReponse carReponse = (CarReponse) o;
        return distance == carReponse.distance && Objects.equals(name, carReponse.name);
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
