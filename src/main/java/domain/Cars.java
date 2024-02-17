package domain;

import dto.CarStatus;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<CarStatus> race() {
        cars.forEach(Car::move);
        return cars.stream()
                .map(Car::getStatus)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseGet(() -> 0);
    }
}
