package racingcar.validator;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static racingcar.exception.ExceptionMessage.*;

public class Validator {
    private Validator() {}

    public static void validateNegativeTryCount(Integer tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException(ILLEGAL_TRY_COUNT.getMessage());
        }
    }

    public static void validateDuplicateCarNames(String[] names) {
        long noDuplicateCount = Arrays.stream(names)
                .distinct()
                .count();
        if (noDuplicateCount != names.length) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME.getMessage());
        }
    }

    public static void validateEmptyCars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalStateException(EMPTY_CARS.getMessage());
        }
    }
}
