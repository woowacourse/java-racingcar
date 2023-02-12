package validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.SplitCarNames;

public class CarNamesValidation {

    private static final int CAR_NAME_LENGTH_MAX = 5;

    public static void validateInputCarNames(String input) {
        validateCountOfCars(input);
        validateNameOfCar(input);
        validateDuplicatedCarName(input);
    }

    public static void validateCarName(String carName) {
        validateCountOfCars(carName);
        validateLengthOfCarName(carName);
    }

    private static void validateCountOfCars(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("자동차를 한 대 이상 작성해주세요.");
        }
    }

    private static void validateNameOfCar(final String input) {
        for (final String carName : splitCarNames(input)) {
            validateLengthOfCarName(carName);
        }
    }

    private static void validateLengthOfCarName(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해주세요.");
        }
    }

    private static void validateDuplicatedCarName(final String input) {
        Set<String> carNameWithoutDuplication = new HashSet<>(List.of(splitCarNames(input)));

        if (carNameWithoutDuplication.size() != splitCarNames(input).length) {
            throw new IllegalArgumentException("자동차 이름은 중복되지 않아야합니다.");
        }
    }

    private static String[] splitCarNames(String input) {
        return SplitCarNames.splitCarNames(input);
    }
}
