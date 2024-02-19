package dto;

import domain.Car;
import domain.Distance;

public class CarStatus implements Comparable<CarStatus>{
    private final String name;
    private final int distance;

    public CarStatus(Car car, int distance) {
        this.name = car.getName();
        this.distance = distance;
    }

    public static CarStatus of(Car car) {
        return new CarStatus(car, car.getDistance().getValue());
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }


    @Override
    public int compareTo(CarStatus other) {
        return this.distance - other.distance;
    }
}
