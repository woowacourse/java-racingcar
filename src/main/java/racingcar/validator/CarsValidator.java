package racingcar.validator;

import racingcar.model.car.Car;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CarsValidator {
    private static final String DUPLICATE_CAR_NAMES_ERROR_MESSAGE = "[ERROR] 중복된 차 이름이 존재합니다.";
    public static void validate(List<Car> carNames) {
        validateDuplicateCarNames(carNames);
    }

    private static void validateDuplicateCarNames(List<Car> carNames) {
        int carNamesCount = carNames.size();
        int distinctCarNamesCount = carNames.stream().map(Car::getCarName).collect(Collectors.toSet()).size();

        if (carNamesCount != distinctCarNamesCount) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAMES_ERROR_MESSAGE);
        }
    }
}
