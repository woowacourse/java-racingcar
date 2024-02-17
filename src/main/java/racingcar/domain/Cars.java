package racingcar.domain;

import static racingcar.util.Constant.MAX_CARS_SIZE;
import static racingcar.util.Constant.MAX_RANDOM_NUMBER;
import static racingcar.util.Constant.MIN_CARS_SIZE;
import static racingcar.exception.ExceptionMessage.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import racingcar.service.RandomNumberGenerator;

public class Cars {
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
        if (cars.size() < MIN_CARS_SIZE.getValue() || cars.size() > MAX_CARS_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_CARS_SIZE.getMessage());
        }
    }

    public void move() {
        cars.forEach(car -> car.move(RandomNumberGenerator.generate(MAX_RANDOM_NUMBER.getValue())));
    }

    public Map<String, Integer> result() {
        return cars.stream()
                .map(Car::result)
                .map(result -> result.entrySet().iterator().next())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (a, b) -> a, LinkedHashMap::new));
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
                .orElseThrow(() -> new IllegalArgumentException(NOT_NULL.getMessage()));
    }
}
