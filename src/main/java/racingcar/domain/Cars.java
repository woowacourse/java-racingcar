package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.exception.ExceptionMessage.DUPLICATE_CAR_NAME;
import static racingcar.exception.ExceptionMessage.EMPTY_CARS;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> cars) {
        validateDuplicateCarNames(cars);
        this.cars = cars.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        validateEmptyCars(this.cars);
    }

    public static void validateEmptyCars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalStateException(EMPTY_CARS.getMessage());
        }
    }

    private void validateDuplicateCarNames(final List<String> cars) {
        List<String> noDuplicateCars = cars.stream()
                .distinct()
                .collect(Collectors.toList());
        if (noDuplicateCars.size() != cars.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME.getMessage());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
