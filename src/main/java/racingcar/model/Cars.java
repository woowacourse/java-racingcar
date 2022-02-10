package racingcar.model;

import racingcar.util.RandomNumberGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void race() {
        this.cars.forEach(car -> {
                    car.move(RandomNumberGenerator.generate());
                });
    }

    public int findMaxPosition() {
        return this.cars.stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(x -> x))
                .orElse(0);
    }

    public String findWinnerName(int maxPosition) {
        return cars.stream()
                .filter(car -> maxPosition == car.getPosition())
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
