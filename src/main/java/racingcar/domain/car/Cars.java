package racingcar.domain.car;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public String getWinners() {
        int max = findMaxMove();
        return cars.stream()
            .filter(car -> car.isOn(max))
            .map(Car::getName)
            .collect(Collectors.joining(","));
    }

    private int findMaxMove() {
        return cars.stream()
            .map(Car::getPosition)
            .max(Integer::compare)
            .orElseThrow(() -> new RuntimeException("No Winner"));
    }

    public List<Car> getCars() {
        return cars;
    }
}
