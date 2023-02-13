package racingcar.domain;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private static final String INVALID_WINNER_MESSAGE = "우승자가 존재하지 않습니다.";
    private static final String DUPLICATED_NAMES_MESSAGE = "중복된 차 이름이 없어야 합니다.";

    private final List<Car> cars;

    public Cars(final List<String> names) {
        validate(names);
        this.cars = toCars(names);
    }

    private void validate(final List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);
        if (names.size() != nonDuplicateNames.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAMES_MESSAGE);
        }
    }

    private List<Car> toCars(final List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(toList());
    }

    public void race(final NumberGenerator strategy) {
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
