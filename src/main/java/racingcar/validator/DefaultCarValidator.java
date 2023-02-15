package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.exception.ErrorMessages.*;

public class DefaultCarValidator implements CarValidator {
    private static final int CAR_NAME_MAX_LENGTH = 5;


    @Override
    public void validateCarNames(List<String> carNames) {
        validateDuplicatedCarName(carNames);
        validateCarsSizeOneOrZero(carNames);
        for (String carName : carNames) {
            validateNameNullOrBlank(carName);
            validateNameLength(carName);
        }
    }

    private void validateNameNullOrBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION.getMessage());
        }
    }

    private void validateNameLength(String name) {
        int nameLength = name.length();
        if (nameLength > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION.getMessage());
        }
    }

    private void validateCarsSizeOneOrZero(List<String> carNames) {
        int carsSize = carNames.size();
        if (carsSize == 0 || carsSize == 1) {
            throw new IllegalArgumentException(CARS_SIZE_EXCEPTION.getMessage());
        }
    }

    private void validateDuplicatedCarName(List<String> carNames) {
        Set<String> duplicatedCheckListToSet = new HashSet<>(carNames);
        if (duplicatedCheckListToSet.size() != carNames.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION.getMessage());
        }
    }
}
