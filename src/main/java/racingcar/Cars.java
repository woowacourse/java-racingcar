package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final int MINIMUM_CAR_AMOUNT = 2;
    private static final String CAR_AMOUNT_LACK_ERROR_MESSAGE = "자동차는 두 대 이상이어야 합니다.";
    private static final String CAR_NAME_DUPLICATION_ERROR_MESSAGE = "자동차의 이름은 중복되지 않아야 합니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarAmount(cars);
        validateCarNameDuplication(cars);
        this.cars = cars;
    }

    private void validateCarAmount(List<Car> cars) {
        if (cars.size() < MINIMUM_CAR_AMOUNT) {
            throw new IllegalArgumentException(CAR_AMOUNT_LACK_ERROR_MESSAGE);
        }
    }

    private void validateCarNameDuplication(List<Car> cars) {
        Set<Car> carsWithoutDuplication = new HashSet<>(cars);
        if (carsWithoutDuplication.size() != cars.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_ERROR_MESSAGE);
        }
    }
}
