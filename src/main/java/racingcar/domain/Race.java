package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private static final int MIN_NUMBER_OF_CARS = 2;
    private final List<Car> cars;
    private final Movable strategy;

    public Race(List<String> names) {
        cars = Collections.unmodifiableList(
            names.stream()
                .map(x -> x.trim())
                .distinct()
                .map(name -> new Car(name))
                .collect(Collectors.toList())
        );
        if (cars.size() < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException();
        }
        strategy = new RandomMovement();
    }

    public Race(List<Car> cars, Movable strategy) {
        this.cars = cars;
        this.strategy = strategy;
    }

    public List<Car> startEachRound() {
        cars.forEach(car -> car.move(strategy));
        return cars;
    }

    public List<Car> getWinners() {
        return cars.stream()
                .filter(x -> x.compareTo(Collections.max(cars)) == 0)
                .collect(Collectors.toList());
    }
}