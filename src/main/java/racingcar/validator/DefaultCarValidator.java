package racingcar.validator;

import java.util.List;

import static racingcar.exception.ErrorMessages.*;

public class DefaultCarValidator implements CarValidator {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    @Override
    public void validateCarName(String name) {
        validateNameNullOrBlank(name);
        validateNameLength(name);
    }

    @Override
    public void validateCarNamesSize(List<String> carNames) {
        validateCarsSizeOneOrZero(carNames);
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
}
