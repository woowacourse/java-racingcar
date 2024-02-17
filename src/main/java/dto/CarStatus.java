package dto;

import domain.Car;

public class CarStatus {
    private final String name;
    private final int distance;

    public CarStatus(Car car) {
        this.name = car.getName();
        this.distance = car.getDistance();
    }

    public static CarStatus of(Car car) {
        return new CarStatus(car);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
