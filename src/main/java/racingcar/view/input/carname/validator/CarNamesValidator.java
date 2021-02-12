package racingcar.view.input.carname.validator;

import java.util.HashSet;
import java.util.List;
import racingcar.view.input.carname.validator.exception.DuplicateCarNamesException;
import racingcar.view.input.carname.validator.exception.LessThanTwoCarNamesException;

public class CarNamesValidator {
    private static final int ALLOWED_MIN_NUMBER_OF_CARS = 2;

    public static void validate(List<String> carNames) {
        validateCountOfCarNames(carNames);
        validateCarNamesDuplicate(carNames);
    }

    private static void validateCountOfCarNames(List<String> carNames) {
        if (carNames.size() < ALLOWED_MIN_NUMBER_OF_CARS) {
            throw new LessThanTwoCarNamesException("경주할 자동차는 두 대 이상이어야 합니다.");
        }
    }

    private static void validateCarNamesDuplicate(List<String> carNames) {
        if (new HashSet<>(carNames).size() != carNames.size()) {
            throw new DuplicateCarNamesException("자동차 이름은 중복되지 않아야 합니다.");
        }
    }
}
