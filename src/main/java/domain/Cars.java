package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarAmount(cars);
        validateDuplicateName(cars);
        this.cars = cars;
    }

    private void validateCarAmount(List<Car> cars) {
        if (cars.size() == 1) {
            throw new IllegalArgumentException(ErrorMessage.MULTIPLE_CARS_REQUIRED.getMessage());
        }
    }

    private void validateDuplicateName(List<Car> cars) {
        Set<Car> validateCar = new HashSet<>(cars);

        if (cars.size() != validateCar.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getMessage());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
