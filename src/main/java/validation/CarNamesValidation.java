package validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNamesValidation {

    private static final int CAR_NAME_LENGTH_MAX = 5;
    private static final int CAR_COUNT_MIN = 0;
    private static final String SPLIT_DELIMITER = ",";

    public static void validateInputCarNames(String input) {
        validateCountOfCars(input);
        validateNameOfCar(input);
        checkDuplicatedCarName(input);
    }

    private static void validateCountOfCars(String input) {
        if (splitCarNames(input).length == CAR_COUNT_MIN || input.isEmpty()) {
            throw new IllegalArgumentException("자동차를 한 대 이상 작성해주세요.");
        }
    }

    private static void validateNameOfCar(final String input) {
        for (final String carName : splitCarNames(input)) {
            if (carName.length() > CAR_NAME_LENGTH_MAX) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해주세요.");
            }
        }
    }

    private static void checkDuplicatedCarName(final String input) {
        Set<String> checkDuplicated = new HashSet<>(List.of(splitCarNames(input)));

        if (checkDuplicated.size() != splitCarNames(input).length) {
            throw new IllegalArgumentException("자동차 이름은 중복되지 않아야합니다.");
        }
    }

    private static String[] splitCarNames(String input) {
        final String[] carNames = input.split(SPLIT_DELIMITER);
        return carNames;
    }
}
