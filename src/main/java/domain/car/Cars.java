package domain.car;

import dto.CarStatus;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<CarStatus> race() {
        return cars.stream()
                .peek(Car::move)
                .map(Car::getStatus)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxDistance() {
        return cars.stream()
                .mapToInt(car -> car.getStatus().distance())
                .max()
                .orElseGet(() -> 0);
    }
}
