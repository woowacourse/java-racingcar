package racingcar.domain;

import static racingcar.exception.ExceptionMessage.*;

import java.util.List;
import racingcar.service.RandomNumberGenerator;

public class Cars {
    private static final int MIN_CARS_SIZE = 2;
    private static final int MAX_CARS_SIZE = 10;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateNotDuplicate(cars);
        validateSize(cars);
        this.cars = cars;
    }

    private void validateNotDuplicate(final List<Car> cars) {
        long uniqueCarNames = cars.stream()
                .distinct()
                .count();
        if (cars.size() != uniqueCarNames) {
            throw new IllegalArgumentException(NOT_DUPLICATED_CAR_NAME.getMessage());
        }
    }

    private void validateSize(final List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE || cars.size() > MAX_CARS_SIZE) {
            throw new IllegalArgumentException(INVALID_CARS_SIZE.getMessage());
        }
    }

    public void move() {
        cars.forEach(car -> car.move(RandomNumberGenerator.generate(MAX_RANDOM_NUMBER)));
    }

    public List<String> result() {
        return cars.stream()
                .map(Car::result)
                .toList();
    }

    public List<String> getWinners() {
        final Car highestPositionCar = getHighestPositionCar();
        return getSamePositionCars(highestPositionCar);
    }

    private List<String> getSamePositionCars(final Car highestPositionCar) {
        return cars.stream()
                .filter(highestPositionCar::isSamePosition)
                .map(Car::getName)
                .toList();
    }

    private Car getHighestPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalArgumentException::new);
    }
}
