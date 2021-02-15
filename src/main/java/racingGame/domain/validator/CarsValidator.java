package racingGame.domain.validator;

import racingGame.domain.racingCar.Car;
import racingGame.domain.racingCar.Name;

import java.util.List;
import java.util.Objects;

public class CarsValidator {

    private CarsValidator() {
    }

    public static void checkIsValidCars(final List<Car> cars) {
        checkIsNull(cars);
        checkIsDuplicated(cars);
    }

    private static void checkIsNull(final List<Car> cars) {
        if (Objects.isNull(cars)) {
            throw new IllegalArgumentException("Cars can't be null");
        }
    }

    private static void checkIsDuplicated(final List<Car> cars) {
        if (cars.stream().distinct().count() != cars.size()) {
            throw new IllegalArgumentException("Duplicated Name exception");
        }
    }

    public static void checkIsValidNames(final List<Name> names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException("Cars can't be created with null");
        }

        if (names.isEmpty()) {
            throw new IllegalArgumentException("Cars can't be created with empty names");
        }
    }
}
