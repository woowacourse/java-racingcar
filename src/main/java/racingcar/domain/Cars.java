package racingcar.domain;

import static racingcar.exception.ExceptionMessage.*;

import java.util.List;
import racingcar.service.RandomNumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<String> carNames) {
        validateNotDuplicate(carNames);
        validateSize(carNames);
        this.cars = createCars(carNames);

    }

    private List<Car> createCars(final List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void validateNotDuplicate(final List<String> carNames) {
        long uniqueCarNames = carNames.stream()
                .distinct()
                .count();
        if (carNames.size() != uniqueCarNames) {
            throw new IllegalArgumentException(NOT_DUPLICATED_CAR_NAME.getMessage());
        }
    }

    private void validateSize(final List<String> carNames) {
        if (carNames.size() < 2 || carNames.size() > 10) {
            throw new IllegalArgumentException(INVALID_CARS_SIZE.getMessage());
        }
    }

    public void move() {
        cars.forEach(car -> car.move(RandomNumberGenerator.generate(9)));
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