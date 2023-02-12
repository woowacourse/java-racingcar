package model;

import exception.ErrorCode;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private static final int MAX_CAR_COUNT = 100;
    private final List<Car> cars;

    public RacingCars(final List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(final List<Car> cars) {
        validateCarDuplicate(cars);
        validateCarCount(cars.size());
    }

    private void validateCarDuplicate(final List<Car> cars) {
        if (isCarDuplicate(cars.stream()
            .map(Car::getName)
            .collect(Collectors.toList()))) {
            throw new IllegalArgumentException(ErrorCode.CAR_NAME_DUPLICATE.getMessage());
        }
    }

    private void validateCarCount(final int size) {
        if (size > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(
                String.format(ErrorCode.TOO_MANY_CAR.getMessage(), MAX_CAR_COUNT));
        }
    }

    private boolean isCarDuplicate(final List<String> carNames) {
        return carNames.size() != carNames.stream()
            .distinct()
            .count();
    }
}
