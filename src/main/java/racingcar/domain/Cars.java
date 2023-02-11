package racingcar.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.Collections;
import java.util.List;

public class Cars {

    private static final String INVALID_WINNER_MESSAGE = "차량이 존재하지 않습니다.";

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

    private Car findWinner() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(INVALID_WINNER_MESSAGE));
    }

    private List<String> findWinners(final Car winner) {
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::getName)
                .collect(toUnmodifiableList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
