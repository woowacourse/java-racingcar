package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class RaceParticipants {
    private final List<Car> cars;

    public RaceParticipants(List<Car> cars) {
        validateDuplicateNames(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateDuplicateNames(List<Car> cars) {
        List<String> carNames = cars.stream().map(Car::getName).toList();
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new InvalidInputException(ErrorMessage.DUPLICATE_CAR_NAMES);
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getRaceWinners() {
        Car winner = cars.stream()
                .max(Car::compareTo)
                .orElseThrow();

        return cars.stream()
                .filter(car -> car.compareTo(winner) == 0)
                .toList();
    }
}
