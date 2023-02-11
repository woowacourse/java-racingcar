package validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNamesValidation {

    private static final int CAR_NAME_LENGTH_MAX = 5;
    private static final int CAR_COUNT_MIN = 0;
    private static final String SPLIT_DELIMITER = ",";

    public static void validateInputCarNames(String input) {
        final String[] cars = input.split(SPLIT_DELIMITER);
        validateCountOfCars(cars);
        validateNameOfCar(cars);
        checkDuplicatedCarName(cars);
    }

    private static void validateCountOfCars(final String[] cars) {
        if (cars.length == CAR_COUNT_MIN) {
            throw new IllegalArgumentException("자동차를 한 대 이상 작성해주세요.");
        }
    }

    private static void validateNameOfCar(final String[] cars) {
        for (final String car : cars) {
            if (car.length() > CAR_NAME_LENGTH_MAX) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해주세요.");
            }
        }
    }

    private static void checkDuplicatedCarName(final String[] cars) {
        Set<String> checkDuplicated = new HashSet<>(List.of(cars));

        if (checkDuplicated.size() != cars.length) {
            throw new IllegalArgumentException("자동차 이름은 중복되지 않아야합니다.");
        }
    }
}
