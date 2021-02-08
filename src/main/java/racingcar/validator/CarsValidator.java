package racingcar.validator;

import racingcar.domain.Car;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class CarsValidator {
    private static final int MIN_CARS_SIZE = 2;

    private CarsValidator() {};

    public static void validate(List<Car> cars) {
        validateCarsSize(cars);
        validateDuplicatedCarNames(cars);
    }

    private static void validateCarsSize(List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE) {
            throw new IllegalArgumentException("자동차는 2대 이상 이어야 합니다.");
        }
    }

    private static void validateDuplicatedCarNames(List<Car> cars) {
        Set<Car> carsSet = new HashSet<>(cars);
        if (cars.size() != carsSet.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복되면 안 됩니다.");
        }
    }
}
