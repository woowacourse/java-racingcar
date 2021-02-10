package racingcar.domain.car;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> findWinners() {
        int max = findMaxMove();
        return cars.stream()
            .filter(car -> car.isOn(max))
            .collect(toList());
    }

    private int findMaxMove() {
        return cars.stream()
            .map(car -> car.getPosition().getValue())
            .max(Integer::compare)
            .orElseThrow(() -> new RuntimeException("No Winner"));
    }

    public List<Car> getCars() {
        return cars;
    }
}
