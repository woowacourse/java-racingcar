package domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(NumberGenerator strategy) {
        for (Car car : cars) {
            car.move(strategy.generate());
        }
    }

    public List<String> findWinners() {
        Car winner = findWinner();
        return findWinners(winner);
    }

    private List<String> findWinners(final Car winner) {
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car findWinner() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
