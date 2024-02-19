package domain;

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
        int duplication = 0;
        Set<String> validateCar = new HashSet<>();
        for (Car car : cars) {
            validateCar.add(car.getCarName());
            duplication = validateCar.size();
        }

        if (cars.size() != duplication) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getMessage());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
