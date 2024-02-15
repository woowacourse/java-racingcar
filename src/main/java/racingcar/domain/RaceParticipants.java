package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class RaceParticipants {
    private final List<Car> cars;

    public RaceParticipants(final List<Car> cars) {
        validateDuplicateNames(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateDuplicateNames(final List<Car> cars) {
        List<String> carNames = cars.stream().map(Car::getName).toList();
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new InvalidInputException(ErrorMessage.DUPLICATE_CAR_NAMES);
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }


    public List<Car> getRaceWinners() {
        Car winner = cars.stream()
                .max(Car::compareTo)
                .orElseThrow();

        return cars.stream()
                .filter(car -> car.compareTo(winner) == 0)
                .toList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
