package domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(collectingAndThen(toList(), Cars::new));
    }

    public void move(final NumberGenerator strategy) {
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
                .collect(toList());
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
