package racingcar.validator;

import racingcar.domain.Car;

import java.util.List;

public class CarsValidator {
    private static final int MINIMUM_CARS_SIZE = 2;

    private CarsValidator() {
    }

    public static void checkIsValidCars(final List<Car> cars) {
        checkIsDuplicated(cars);
        checkValidCarSize(cars);
    }

    private static void checkIsDuplicated(final List<Car> cars) {
        if (cars.stream().distinct().count() != cars.size()) {
            throw new IllegalArgumentException("Duplicated Name exception");
        }
    }

    private static void checkValidCarSize(final List<Car> cars) {
        if (cars.size() < MINIMUM_CARS_SIZE) {
            throw new IllegalArgumentException("There must be at least two cars");
        }
    }
}
