package racingcar.domain.validator;

import racingcar.domain.Car;

import java.util.List;

public class CarsValidator {

    private CarsValidator() {
    }

    public static void checkIsValidCars(final List<Car> cars) {
        checkIsDuplicated(cars);
    }

    private static void checkIsDuplicated(final List<Car> cars) {
        if (cars.stream().distinct().count() != cars.size()) {
            throw new IllegalArgumentException("Duplicated Name exception");
        }
    }
}
