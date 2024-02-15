package domain;

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
}
