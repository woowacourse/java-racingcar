package domain.car;

import domain.racing.RacingRule;
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

    public List<String> findWinnerNames(RacingRule rule) {
        return rule.findWinnerCars(cars)
                .stream()
                .map(Car::getName)
                .toList();
    }
}
